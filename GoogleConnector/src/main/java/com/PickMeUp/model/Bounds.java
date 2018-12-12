package com.PickMeUp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bounds
{
	@JsonProperty("northeast")
	private LatLng	northeast;

	@JsonProperty("southwest")
	private LatLng	southwest;

	public LatLng getNortheast()
	{
		return northeast;
	}

	public void setNortheast(LatLng northeast)
	{
		this.northeast = northeast;
	}

	public LatLng getSouthwest()
	{
		return southwest;
	}

	public void setSouthwest(LatLng southwest)
	{
		this.southwest = southwest;
	}
}
