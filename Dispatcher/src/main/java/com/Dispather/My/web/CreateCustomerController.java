package com.Dispather.My.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import com.Dispather.My.Rest.CustomerRequestController;
import com.Dispather.My.model.Email;
import com.Dispather.My.rabbitMQueue.Runner;
import com.Dispather.My.service.CustomerService;
import com.Dispather.My.utils.ProcessManagement;
import com.Dispather.My.utils.model.UniqueProcessRef;
import com.Dispather.My.web.bean.CustomerBean;

@Controller
public class CreateCustomerController
{
	private static final Logger	log	= LoggerFactory
			.getLogger(CustomerRequestController.class);

	@Autowired
	private ProcessManagement	processManagement;

	@Autowired
	private CustomerService		costumerService;
	@Autowired
	private ApplicationContext appContext;

	@Autowired
	private Runner runner;
	
	public void addViewControllers(ViewControllerRegistry registry)
	{
		registry.addViewController("/results").setViewName("results");
	}

	@GetMapping("/")
	public String showForm(CustomerBean customerBean)
	{
		return "createcustomer";
	}

	@PostMapping("/")
	public String checkPersonInfo(@Valid CustomerBean customerBean,
			BindingResult bindingResult)
	{
		UniqueProcessRef upr = processManagement.createUniqueSequence();
		try
		{
			runner.sendMessage(upr.toString());
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		log.info(upr.toString());
		log.info("Trying to save '{}' ", customerBean);
		if (bindingResult.hasErrors()) 
		{
		
			log.info("failed {} \n{}", upr.toString(), customerBean.toString());
			log.info("errors {} \n{}", bindingResult.getAllErrors());
			return "createcustomer"; 
		}
		costumerService.SaveCustomer(customerBean, upr);
		JmsTemplate jmsTemplate = appContext.getBean(JmsTemplate.class);
		jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello"));
		jmsTemplate.convertAndSend("mailbox2", new Email("info@example.com", "Hello"));

		return "redirect:/";
	}
}
