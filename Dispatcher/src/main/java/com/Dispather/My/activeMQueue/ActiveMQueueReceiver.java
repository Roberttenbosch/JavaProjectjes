package com.Dispather.My.activeMQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.Dispather.My.model.Email;

@Component
public class ActiveMQueueReceiver
{
	private static final Logger log = LoggerFactory
			.getLogger(ActiveMQueueReceiver.class); 
	
   @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(Email email) {
	   log.info("Dispatcher activeMQ Received  <" + email + ">");
    }
}
