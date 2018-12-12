package com.PickMeUp.web;

import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.PickMeUp.service.LocationService;
import com.PickMeUp.service.UrlAndUrlService;
import com.PickMeUp.web.bean.LocationRequestBean;

@Controller
public class LocationController extends BaseController
{
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private UrlAndUrlService urlService;
	
	@GetMapping("/")
	public String home(Model model, LocationRequestBean locationRequestBean)
	{
		
		log.info("Handling home");
		return "home";
	} 
	
	@PostMapping("/")
	public String getLocationPoint(Model model, LocationRequestBean locationRequestBean,
			BindingResult bindingResult)
	{
		log.info("Request: {}",locationRequestBean);
		if (bindingResult.hasErrors()) 
		{
			log.info("errors {} \n{}", bindingResult.getAllErrors());
			return "redirect:/"; 
		}
		URL result = urlService.createUserLocationWithPlaceIdUrl(locationService.getPlaceId(locationRequestBean.getLocation()));
		log.info(result.toString());
		model.addAttribute("mapSrcUrl", result.toString());
		
		return "home";
	}

}
