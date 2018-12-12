package com.PickMeUp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodingResponse
{
	@JsonProperty("results")
	private GeocodingResult[] result;
	
	public GeocodingResult[] getResult()
	{
		return result;
	}
	public void setResult(GeocodingResult[] result)
	{
		this.result = result;
	}
}
