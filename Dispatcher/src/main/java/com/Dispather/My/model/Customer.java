package com.Dispather.My.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DISPATCHER_CUSTOMER")

public class Customer
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUS_ID")
	private Long	customerId;

	@Column(name = "CUS_NAME")
	private String	name;

	@Column(name = "CUS_PHONENUMBER")
	private String	phoneNumber;

	@Column(name = "CUS_PROCESS_REF")
	private String	processRef;

	public Long getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(Long customerId)
	{
		this.customerId = customerId;
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

	public String getProcessRef()
	{
		return processRef;
	}

	public void setProcessRef(String processRef)
	{
		this.processRef = processRef;
	}



}
