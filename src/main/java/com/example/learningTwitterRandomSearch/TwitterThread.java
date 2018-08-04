package com.example.learningTwitterRandomSearch;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.*;

public class TwitterThread extends Thread{
    final String TWITTER_CONSUMER_KEY = System.getenv("TWITTER_CONSUMER_KEY");
    final String TWITTER_CONSUMER_SECRET = System.getenv("TWITTER_CONSUMER_SECRET");
    final String TWITTER_ACCESS_TOKEN = System.getenv("TWITTER_ACCESS_TOKEN");
    final String TWITTER_ACCESS_TOKEN_SECRET = System.getenv("TWITTER_ACCESS_TOKEN_SECRET");
    final String TWITTER_ACCOUNT = System.getenv("TWITTER_ACCOUNT");

    private TwitterStream twitterStream;
    private boolean isActive = true;

    public TwitterThread(){
        var cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
            .setOAuthConsumerKey(TWITTER_CONSUMER_KEY)
            .setOAuthConsumerSecret(TWITTER_CONSUMER_SECRET)
            .setOAuthAccessToken(TWITTER_ACCESS_TOKEN)
            .setOAuthAccessTokenSecret(TWITTER_ACCESS_TOKEN_SECRET);
        twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
    }
    
    @Override
	public void run(){
        System.out.println("-----receive start-----");
        var listener = new StatusListener() {
            @Override
            public void onStatus(Status status) {
                System.out.println("Get a status. " + "@" + status.getUser().getScreenName() + " - " + status.getText());
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
                System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
            }

            @Override
            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
                System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
            }

            @Override
            public void onScrubGeo(long userId, long upToStatusId) {
                System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
            }

            @Override
            public void onStallWarning(StallWarning warning) {
                System.out.println("Got stall warning:" + warning);
            }

            @Override
            public void onException(Exception ex) {
                ex.printStackTrace();
            }
        };
        twitterStream.addListener(listener);
        var filterQuery = new FilterQuery();
        filterQuery.track(new String[] {String.format("@%s", TWITTER_ACCOUNT)});
        twitterStream.filter(filterQuery);

        System.out.println("-----waiting-----");
        while(this.isActive) {
            // waiting...
        }
    }
    
    public void stopThread() {
        System.out.println("-----receive stop-----");
        this.isActive = false;
        twitterStream.shutdown();
    }
}