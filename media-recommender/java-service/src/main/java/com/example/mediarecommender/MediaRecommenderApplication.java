package com.example.mediarecommender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MediaRecommenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediaRecommenderApplication.class, args);
	}

}
