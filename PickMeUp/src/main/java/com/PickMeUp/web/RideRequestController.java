package com.PickMeUp.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.PickMeUp.web.bean.RideRequestBean;


@Controller
public class RideRequestController extends BaseController
{

	@GetMapping("/riderequest")
	public String home(RideRequestBean rideRequestBean)
	{
		
		log.info("Handling home");
		return "home";
	} 
	
	@PostMapping("/riderequest")
	public String postRideRequest(RideRequestBean rideRequestBean,
			BindingResult bindingResult)
	{
		log.info("Request: {}",rideRequestBean);
		if (bindingResult.hasErrors()) 
		{
		
			log.info("errors {} \n{}", bindingResult.getAllErrors());
			return "redirect:/"; 
		}
		log.info("Request: {}",rideRequestBean );
		return "redirect:/";
	}

}
