package com.PickMeUp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressComponent
{
	@JsonProperty("long_name")
	private String					longName;
	
	@JsonProperty("short_name")
	private String					shortName;
	
	//@JsonProperty("types")
	//private AddressComponentType[]	types;

	public String getLongName()
	{
		return longName;
	}

	public void setLongName(String longName)
	{
		this.longName = longName;
	}

	public String getShortName()
	{
		return shortName;
	}

	public void setShortName(String shortName)
	{
		this.shortName = shortName;
	}
/*
	public AddressComponentType[] getTypes()
	{
		return types;
	}

	public void setTypes(AddressComponentType[] types)
	{
		this.types = types;
	}*/

}
