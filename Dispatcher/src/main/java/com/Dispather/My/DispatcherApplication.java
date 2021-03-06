package com.Dispather.My;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;

@EnableJpaRepositories
@EnableJms
@SpringBootApplication(exclude =
{ DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class })
public class DispatcherApplication extends SpringBootServletInitializer 
{
	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder)
	{
		return builder.sources(DispatcherApplication.class);
	}

	public static void main(String[] args)
	{
		SpringApplication.run(DispatcherApplication.class, args);
	}
}
