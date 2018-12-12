package com.Dispather.My.rabbitMQueue;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class Receiver
{
	private static final Logger log = LoggerFactory
			.getLogger(Receiver.class);
	
	private CountDownLatch latch = new CountDownLatch(0);

	public void receiveMessage(String message)
	{
		log.info("Dispatcher RabbitMQ Received  <" + message + ">");
		latch.countDown();
	}

	public CountDownLatch getLatch()
	{
		return latch;
	}
}
