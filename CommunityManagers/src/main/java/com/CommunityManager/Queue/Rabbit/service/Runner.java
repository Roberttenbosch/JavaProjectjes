package com.CommunityManager.Queue.Rabbit.service;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.CommunityManager.Queue.CommunityManagersApplication;

@Component
public class Runner implements CommandLineRunner
{

	private final RabbitTemplate rabbitTemplate;
	 private final Receiver receiver;

	public Runner(RabbitTemplate rabbitTemplate, Receiver receiver)
	{
		this.receiver = receiver;
		this.rabbitTemplate = rabbitTemplate;
	}

	@Override
	public void run(String... args) throws Exception
	{
		System.out.println("Sending message...");
		rabbitTemplate.convertAndSend(
				CommunityManagersApplication.topicExchangeName, "foo.bar.baz",
				"Hell RabbitMQ!");
		 receiver.getLatch().await(1000, TimeUnit.MILLISECONDS);
	}

}
