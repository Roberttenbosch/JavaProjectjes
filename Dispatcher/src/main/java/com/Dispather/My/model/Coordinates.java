package com.Dispather.My.model;

import javax.persistence.Entity;
import javax.persistence.Table;

public class Coordinates
{
	private double	latitude;
	private double	longitude;

	public double getLatitude()
	{
		return latitude;
	}

	public void setLatitude(double latitude)
	{
		this.latitude = latitude;
	}

	public double getLongitude()
	{
		return longitude;
	}

	public void setLongitude(double longitude)
	{
		this.longitude = longitude;
	}

}
