package com.PickMeUp.model;

public enum GoogleLocationOption
{
	LATLNG("latlng"), ADDRESS("address");
	private String name;
	
	 GoogleLocationOption(String name)
	{
		this.name = name;
	}
	
	public String toString()
	{
		return name;
	}
}
