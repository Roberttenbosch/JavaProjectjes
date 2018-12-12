package com.PickMeUp.service;

import java.util.Locale;

import javax.mail.MessagingException;

public interface MailSendService
{

	void sendSimpleMail(String recipientName, String recipientEmail,
			Locale locale, String station) throws MessagingException;

}
