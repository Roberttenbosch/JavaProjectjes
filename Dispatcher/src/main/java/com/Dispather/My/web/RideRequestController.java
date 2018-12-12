package com.Dispather.My.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Dispather.My.service.RideRequestService;
import com.Dispather.My.utils.ProcessManagement;
import com.Dispather.My.utils.model.UniqueProcessRef;
import com.Dispather.My.web.bean.RideRequestBean;

@Controller
public class RideRequestController
{
	private static final Logger	log	= LoggerFactory
			.getLogger(RideRequestController.class);
	
	@Autowired
	private ProcessManagement	processManagement;

	@Autowired
	private RideRequestService rideRequestService;

	@GetMapping("/riderequest")
	public String rideRequest(RideRequestBean rideRequestBean)
	{
		return "riderequest";
	}

	@PostMapping("/riderequest")
	public String postRideRequest(RideRequestBean rideRequestBean,
			BindingResult bindingResult)
	{
		UniqueProcessRef upr = processManagement.createUniqueSequence();
		
		log.info(upr.toString());
		if (bindingResult.hasErrors()) 
		{
		
			log.info("failed {} \n{}", upr.toString(), rideRequestBean.toString());
			log.info("errors {} \n{}", bindingResult.getAllErrors());
			return "riderequest"; 
		}
		
		rideRequestService.getCoordinates(rideRequestBean.getFromLocation());
		log.info("Success {} \n{}", upr.toString(), rideRequestBean.toString());

		return "redirect:/riderequest";
	}
}
