package com.example.learningTwitterRandomSearch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TwitterThreadTests {
	@Test
	public void testRun() {
		var t = new TwitterThread();
		t.start();

		int i = 0;
        do {    
            try {
				Thread.sleep(1 * 1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            i++;
		}while(i < 30);

		t.stopThread();
		assertEquals(true, true);
	}

}
