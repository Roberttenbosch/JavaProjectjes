package com.PickMeUp.web.bean;

import javax.validation.constraints.Size;

public class LocationRequestBean
{
	@Size(min = 2, max = 30)
	private String location;

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	@Override
	public String toString()
	{
		return "RideRequestBean [ Location=" + location + "]";
	}
}
