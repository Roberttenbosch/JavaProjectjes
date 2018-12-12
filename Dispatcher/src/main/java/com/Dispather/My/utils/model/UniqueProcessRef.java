package com.Dispather.My.utils.model;

public class UniqueProcessRef
{
	private String UUID;
	private Long CustomerId;
	private String time;
	
	
	public UniqueProcessRef(String uUID, Long customerId, String time)
	{
		UUID = uUID;
		CustomerId = customerId;
		this.time = time;
	}
	
	public String getUUID()
	{
		return UUID;
	}
	public void setUUID(String uUID)
	{
		UUID = uUID;
	}
	public Long getCustomerId()
	{
		return CustomerId;
	}
	public void setCustomerId(Long customerId)
	{
		CustomerId = customerId;
	}
	public String getTime()
	{
		return time;
	}
	public void setTime(String time)
	{
		this.time = time;
	}

	@Override
	public String toString()
	{
		return "{" + UUID + ":" + CustomerId
				+ ":" + time + "}";
	}
	
	
}
