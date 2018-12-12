package com.Dispather.My.Rest.Bean;

public class CustomerCountBean
{
	String	name;
	long	count;

	public CustomerCountBean(long count, String name)
	{
		
		this.count = count;
		this.name = name;
	}

	public long getCount()
	{
		return count;
	}

	public void setCount(long count)
	{
		this.count = count;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
