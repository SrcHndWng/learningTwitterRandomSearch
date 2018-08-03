package com.example.learningTwitterRandomSearch;

import org.springframework.stereotype.Component;

import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.*;

@Component
public class Twitter {
    final String TWITTER_CONSUMER_KEY = System.getenv("TWITTER_CONSUMER_KEY");
    final String TWITTER_CONSUMER_SECRET = System.getenv("TWITTER_CONSUMER_SECRET");
    final String TWITTER_ACCESS_TOKEN = System.getenv("TWITTER_ACCESS_TOKEN");
    final String TWITTER_ACCESS_TOKEN_SECRET = System.getenv("TWITTER_ACCESS_TOKEN_SECRET");
    final String TWITTER_ACCOUNT = System.getenv("TWITTER_ACCOUNT");

    public Twitter(){
    }

    public void receive() throws TwitterException{
        System.out.println("-----receive start-----");
        System.out.println(TWITTER_CONSUMER_KEY);
        System.out.println(TWITTER_CONSUMER_SECRET);
        System.out.println(TWITTER_ACCESS_TOKEN);
        System.out.println(TWITTER_ACCESS_TOKEN_SECRET);
        System.out.println(TWITTER_ACCOUNT);

        var cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
            .setOAuthConsumerKey(TWITTER_CONSUMER_KEY)
            .setOAuthConsumerSecret(TWITTER_CONSUMER_SECRET)
            .setOAuthAccessToken(TWITTER_ACCESS_TOKEN)
            .setOAuthAccessTokenSecret(TWITTER_ACCESS_TOKEN_SECRET);
        var tf = new TwitterFactory(cb.build());
        var twitter = tf.getInstance();
        var statuses = twitter.getMentionsTimeline();
        for (var status : statuses) {
            System.out.println(
                "《Statusの表示》\n"
                + "getName > " + status.getUser().getName() + " : \n"
                + "getScreenName > " + status.getUser().getScreenName() + " : \n"
                + "getInReplyToScreenName > " + status.getInReplyToScreenName() + " : \n"
                + "getInReplyToStatusId > " + status.getInReplyToStatusId() + " : \n" // 返信じゃない -1
                + "getInReplyToUserId > " + status.getInReplyToUserId() + " : \n"
                + "getCreatedAt > " + status.getCreatedAt().toString() + " : \n"
                + "getText > " + status.getText() + " : \n"
                + "getId > " + status.getId()
            );
        }
        System.out.println("-----receive end-----");
    }
}