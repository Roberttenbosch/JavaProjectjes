package com.PickMeUp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan
@SpringBootApplication
@EnableScheduling
public class NsConnectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(NsConnectorApplication.class, args);
	}
}
