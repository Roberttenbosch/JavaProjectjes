package com.PickMeUp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class DepartingTrain
{
	@XmlElement(name = "RitNummer")
	private int		number;
	@XmlElement(name = "VertrekTijd")
	private String	departureTime;
	@XmlElement(name = "EindBestemming")
	private String	finalDestination;
	@XmlElement(name = "VertrekVertraging")
	private String	delay;
	@XmlElement(name = "VertrekVertragingTekst")
	private String	delayText;
	@XmlElement(name = "TreinSoort")
	private String	category;
	@XmlElement(name = "RouteTekst")
	private String	routeText;
	@XmlElement(name = "Vervoerder")
	private String	contracter;
	@XmlElement(name = "VertrekSpoor")
	private String	platform;

	public int getNumber()
	{
		return number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}

	public String getDepartureTime()
	{
		return departureTime;
	}

	public void setDepartureTime(String departureTime)
	{
		this.departureTime = departureTime;
	}

	public String getFinalDestination()
	{
		return finalDestination;
	}

	public void setFinalDestination(String finalDestination)
	{
		this.finalDestination = finalDestination;
	}

	public String getDelay()
	{
		return delay;
	}

	public void setDelay(String delay)
	{
		this.delay = delay;
	}

	public String getDelayText()
	{
		return delayText;
	}

	public void setDelayText(String delayText)
	{
		this.delayText = delayText;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public String getRouteText()
	{
		return routeText;
	}

	public void setRouteText(String routeText)
	{
		this.routeText = routeText;
	}

	public String getContracter()
	{
		return contracter;
	}

	public void setContracter(String contracter)
	{
		this.contracter = contracter;
	}

	public String getPlatform()
	{
		return platform;
	}

	public void setPlatform(String platform)
	{
		this.platform = platform;
	}
}
