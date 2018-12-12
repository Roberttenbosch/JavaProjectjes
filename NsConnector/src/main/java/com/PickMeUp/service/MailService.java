package com.PickMeUp.service;

import org.springframework.mail.javamail.JavaMailSender;

public interface MailService
{

	public JavaMailSender getJavaMailSender();

}
