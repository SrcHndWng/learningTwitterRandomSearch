package com.example.learningTwitterRandomSearch;

import org.springframework.stereotype.Component;

@Component
public class Twitter {
    final String TWITTER_CONSUMER_KEY = System.getenv("TWITTER_CONSUMER_KEY");
    final String TWITTER_CONSUMER_SECRET = System.getenv("TWITTER_CONSUMER_SECRET");
    final String TWITTER_ACCESS_TOKEN = System.getenv("TWITTER_ACCESS_TOKEN");
    final String TWITTER_ACCESS_TOKEN_SECRET = System.getenv("TWITTER_ACCESS_TOKEN_SECRET");
    final String TWITTER_ACCOUNT = System.getenv("TWITTER_ACCOUNT");

    public Twitter(){
    }

    public void receive(){
        System.out.println("-----receive-----");
        System.out.println(TWITTER_CONSUMER_KEY);
        System.out.println(TWITTER_CONSUMER_SECRET);
        System.out.println(TWITTER_ACCESS_TOKEN);
        System.out.println(TWITTER_ACCESS_TOKEN_SECRET);
        System.out.println(TWITTER_ACCOUNT);
    }
}