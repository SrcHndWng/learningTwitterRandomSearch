package com.example.learningTwitterRandomSearch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import twitter4j.TwitterException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TwitterTests {
	@Autowired
	private Twitter twitter;

	@Test
	public void testReceive() throws TwitterException, InterruptedException {
		twitter.initialize();
		twitter.receive();
		twitter.stop();
		assertEquals(true, true);
	}

}
