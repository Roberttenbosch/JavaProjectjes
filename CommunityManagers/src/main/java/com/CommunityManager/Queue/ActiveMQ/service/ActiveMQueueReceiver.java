package com.CommunityManager.Queue.ActiveMQ.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.CommunityManager.Queue.ActiveMQ.model.Email;


@Component
public class ActiveMQueueReceiver
{
	private static final Logger log = LoggerFactory
			.getLogger(ActiveMQueueReceiver.class); 
	
   @JmsListener(destination = "mailbox2", containerFactory = "myFactory")
    public void receiveMessage(Email email) {
	   log.info("communitie activeMQ Received  <" + email + ">");
    }
}
