package com.example.learningTwitterRandomSearch;

import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    private TwitterThread twitterThread = null;

    public static void main(String[] args) {
        try (ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args)) {
            Application app = ctx.getBean(Application.class);
            app.run();
        } catch (Exception e) {
            System.out.println("Application Error!");
            e.printStackTrace();
        }
    }

    private void run() throws Exception {
        System.out.println("Application Run!");
        twitterThread = new TwitterThread();
        twitterThread.start();
        while (true) {
            Thread.sleep(10 * 1000L);
        }
    }

    @PreDestroy
    public void exit() {
        if (twitterThread != null) {
            twitterThread.stopThread();
        }
        System.out.println("Application exit!");
    }
}
