package com.PickMeUp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class GoogleConnectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoogleConnectorApplication.class, args);
	}
}
