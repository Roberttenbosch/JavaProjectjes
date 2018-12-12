package com.Dispather.My.web.bean;

import javax.validation.constraints.NotNull;

public class CustomerBean
{
	@NotNull
  //  @Size(min=2, max=30)
	private String name;
	
	@NotNull
    //@Size(min=10, max=15)
	private String phoneNumber;
	
	
	public CustomerBean(@NotNull String name,
			@NotNull String phoneNumber)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString()
	{
		return "CustomerBean [name=" + name + ", phoneNumber=" + phoneNumber
				+ "]";
	}
	
	
}
