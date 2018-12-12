package com.PickMeUp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ActueleVertrekTijden")
public class DepartureResponse
{
	@XmlElement(name="VertrekkendeTrein")
	private DepartingTrain[] trains;

	public DepartingTrain[] getTrains()
	{
		return trains;
	}

	public void setTrains(DepartingTrain[] trains)
	{
		this.trains = trains;
	}
	
	
}
