package com.CommunityManager.Queue.Rabbit.service;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class Receiver
{
	private static final Logger log = LoggerFactory
			.getLogger(Receiver.class);
	
	private CountDownLatch latch = new CountDownLatch(5);

	public void receiveMessage(String message)
	{
		log.info("CommunitityManager Received <" + message + ">");
		latch.countDown();
	}

	public CountDownLatch getLatch()
	{
		return latch;
	}

}
