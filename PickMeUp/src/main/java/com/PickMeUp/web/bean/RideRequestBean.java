package com.PickMeUp.web.bean;

import javax.validation.constraints.Size;

public class RideRequestBean
{
	private String	fromLocation;
	private String	toLocation;

	public String getFromLocation()
	{
		return fromLocation;
	}

	public void setFromLocation(String fromLocation)
	{
		this.fromLocation = fromLocation;
	}

	public String getToLocation()
	{
		return toLocation;
	}

	public void setToLocation(String toLocation)
	{
		this.toLocation = toLocation;
	}

	@Override
	public String toString()
	{
		return "RideRequestBean [fromLocation=" + fromLocation + ", toLocation="
				+ toLocation + "]";
	}

}
