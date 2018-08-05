package com.example.learningTwitterRandomSearch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TweetsTests {
	@Test
	public void testSelect() {
        var tweets = new Tweets();
        tweets.add("account1", 100, 1, 2);
        tweets.add("account2", 200, 3, 4);
        tweets.add("account3", 300, 5, 6);
        var result = tweets.select();
        System.out.println(result);
        assertNotNull("result is null.", result);
	}

}
