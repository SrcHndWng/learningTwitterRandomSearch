package com.example.learningTwitterRandomSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	@Autowired
	private Twitter twitter;

	public static void main(String[] args) {
		try (ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args)) {
			Application app = ctx.getBean(Application.class);
			app.run();
		} catch (Exception e){
			System.out.println("Application Error!");
			e.printStackTrace();
		}
	}

	private void run() throws Exception {
		var greeting = "Hello";
		var framework = "Spring Boot 2";
		System.out.println("Application Run!");
		System.out.println(String.format("%s %s!", greeting, framework));
		twitter.initialize();
		twitter.receive();
		twitter.stop();
	}
}
