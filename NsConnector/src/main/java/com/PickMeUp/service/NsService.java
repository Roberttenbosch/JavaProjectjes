package com.PickMeUp.service;

import com.PickMeUp.model.DepartureResponse;

public interface NsService
{

	public void getMaintenanceAndMalfunctions();

	public DepartureResponse getCurrentDepartureTime(String station);

}
