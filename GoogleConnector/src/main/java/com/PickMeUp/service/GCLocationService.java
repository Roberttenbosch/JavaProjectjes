package com.PickMeUp.service;

public interface GCLocationService
{

	public String getFormattedAddress(String location);
	public String getLocation(String lat, String lng);
	public String getPlaceIdByLoction(String location);

}
