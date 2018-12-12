package com.PickMeUp.model;

public enum OutputFormat
{
	JSON("json"), XML("xml");

	private String format;

	OutputFormat(String format)
	{
		this.format = format;
	}

	public String format()
	{
		return format;
	}
}
