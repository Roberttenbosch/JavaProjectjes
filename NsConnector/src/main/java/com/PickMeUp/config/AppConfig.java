package com.PickMeUp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.PickMeUp.service.BaseService;

@Configuration
public class AppConfig extends BaseService
{
	
	@Value("${ns.webservices.api.username}")
    private String username;
	@Value("${ns.webservices.api.password}")
	private String password;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public RestTemplate restTemplateNs(RestTemplateBuilder builder) {
		builder.basicAuthorization(username, password);
		return builder.build();
	}
}
