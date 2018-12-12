package com.Dispather.My.rabbitMQueue;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class Runner
{
	private final RabbitTemplate rabbitTemplate;
	private final Receiver receiver;

	public Runner(RabbitTemplate rabbitTemplate, Receiver receiver)
	{
		this.receiver = receiver;
		this.rabbitTemplate = rabbitTemplate;
	}

	public void sendMessage(String message) throws InterruptedException {
		System.out.println("Sending message..." + message);
		rabbitTemplate.convertAndSend(
				MessageQueueConfig.topicExchangeName, "manager.dispatcher.baz",
				message);
		receiver.getLatch().await(1000, TimeUnit.MILLISECONDS);
	}
}
