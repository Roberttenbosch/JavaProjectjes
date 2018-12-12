package com.PickMeUp.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.PickMeUp.service.GCLocationService;

@Controller()
public class LocationRestController extends BaseController
{
	@Autowired
	private GCLocationService gCLocationService;
	
	@GetMapping("/formattedaddress")
	@ResponseBody
	public String getFormattedAddress(@RequestParam("location") String location)
	{
		log.info("location {}", location);
		if(!StringUtils.isEmpty(location))
		{
			return gCLocationService.getFormattedAddress(location);
			
		}
		log.info("return BadRequest");
		return HttpStatus.BAD_REQUEST.toString();
	}
	
	@GetMapping("/result")
	@ResponseBody
	public String getLocation(@RequestParam("lat") String lat, @RequestParam("lng") String lng)
	{
		log.info("lat {}", lat);
		log.info("location {}", lng);
		if(!(StringUtils.isEmpty(lat) || StringUtils.isEmpty(lng)))
		{
			return gCLocationService.getLocation(lat, lng);
		}
		log.info("return BadRequest");
		return HttpStatus.BAD_REQUEST.toString();
	}
	@GetMapping("/placeid")
	@ResponseBody
	public String getPlaceId(@RequestParam("location") String location)
	{
		log.info("location {}", location);
		if(!StringUtils.isEmpty(location))
		{
			return gCLocationService.getPlaceIdByLoction(location);
			
		}
		log.info("return BadRequest");
		return HttpStatus.BAD_REQUEST.toString();
	}
}
