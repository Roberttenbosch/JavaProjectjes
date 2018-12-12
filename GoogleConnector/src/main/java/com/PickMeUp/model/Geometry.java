package com.PickMeUp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Geometry
{
	@JsonProperty("bounds")
	private Bounds			bounds;

	@JsonProperty("location")
	private LatLng			location;

//	@JsonProperty("location_type")
	private LocationType	locationType;

	@JsonProperty("viewport")
	private Bounds			viewport;

	public Bounds getBounds()
	{
		return bounds;
	}

	public void setBounds(Bounds bounds)
	{
		this.bounds = bounds;
	}

	public LatLng getLocation()
	{
		return location;
	}

	public void setLocation(LatLng location)
	{
		this.location = location;
	}

	public LocationType getLocationType()
	{
		return locationType;
	}

	public void setLocationType(LocationType locationType)
	{
		this.locationType = locationType;
	}

	public Bounds getViewport()
	{
		return viewport;
	}

	public void setViewport(Bounds viewport)
	{
		this.viewport = viewport;
	}

}
