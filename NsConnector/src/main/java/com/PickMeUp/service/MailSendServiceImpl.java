package com.PickMeUp.service;

import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.PickMeUp.model.DepartingTrain;
import com.PickMeUp.model.DepartureResponse;

@Service
public class MailSendServiceImpl extends BaseService implements MailSendService
{
	private static final String	EMAIL_SIMPLE_TEMPLATE_NAME	= "email-simple";

	@Value("${spring.email.template.encoding}")
	private String				emailEncoding;

	@Autowired
	private JavaMailSender		mailSender;

	@Autowired
	private TemplateEngine		htmlTemplateEngine;

	@Value("${spring.mail.username}")
	private String				username;

	@Autowired
	private NsService			nsService;

	@Value("${spring.mail.subject.delay}")
	private String				delayMessage;

	@Value("${spring.mail.subject.nodelay}")
	private String				noDelayMessage;

	@Override
	public void sendSimpleMail(final String recipientName,
			final String recipientEmail, final Locale locale, String station)
			throws MessagingException
	{
		DepartureResponse res = nsService.getCurrentDepartureTime(station);
		// Prepare the evaluation context
		final Context ctx = new Context(locale);
		ctx.setVariable("name", recipientName);
		ctx.setVariable("subscriptionDate", new Date());
		ctx.setVariable("trains", Arrays.asList(res.getTrains()));
		// Prepare message using a Spring helper
		final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
		final MimeMessageHelper message = new MimeMessageHelper(mimeMessage,
				emailEncoding);
		boolean delayed = areDalayes(res);
		String subject = getSubjectLine(delayed);
		message.setSubject(subject);
		message.setFrom(username);
		message.setTo(recipientEmail);
		String mailtext = getMailText(res);
		message.setText(mailtext, true /* isHtml */);

		// Send email
		this.mailSender.send(mimeMessage);
	}

	private String getMailText(DepartureResponse res)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Vertragingen van vandaag");
		for (DepartingTrain train : res.getTrains())
		{
			if (!StringUtils.isEmpty(train.getDelay()))
			{

				sb.append("\nDe trein:\n");
				sb.append(train.getRouteText());
				sb.append("\nEindbestemming\t");
				sb.append(train.getFinalDestination());
				sb.append("\nVetrektijd:\t");
				sb.append(train.getDepartureTime());
				sb.append("\nvertraging:\t");
				sb.append(train.getDelayText());
				sb.append("\n");
				sb.append(train.getNumber());
				sb.append("\n");
				sb.append(train.getCategory());
				sb.append("\n-------------------------------------------\n");
			}
		}
		return sb.toString();
	}

	private String getSubjectLine(boolean delayed)
	{
		String toReturn = "";
		if (delayed)
		{
			toReturn = delayMessage;
		}
		else
		{
			toReturn = noDelayMessage;
		}
		return toReturn + " " + new Date().toString();
	}

	private boolean areDalayes(DepartureResponse res)
	{
		for (DepartingTrain train : res.getTrains())
		{
			if (!StringUtils.isEmpty(train.getDelay())) { return true; }
		}
		return false;
	}

	@Scheduled(cron = "0 35 7 * * MON-FRI") // "*/10 * * * * *"
	public void sendMailOmVijfOverHalfAchtUur()
	{
		log.info("start sending");
		Locale locale = LocaleContextHolder.getLocale();
		try
		{
			sendSimpleMail("Robert", "Roberttenbosch@Gmail.com", locale,
					"apeldoorn");
		}
		catch (MessagingException e)
		{
			log.info(e.getMessage());
			e.printStackTrace();
		}
	}
	@Scheduled(cron = "0 0 17 * * MON-FRI") // "*/10 * * * * *"
	public void sendMailOmVijfUur()
	{
		log.info("start sending");
		Locale locale = LocaleContextHolder.getLocale();
		try
		{
			sendSimpleMail("Robert", "Roberttenbosch@Gmail.com", locale,
					"deventer");
		}
		catch (MessagingException e)
		{
			log.info(e.getMessage());
			e.printStackTrace();
		}
	}
}
