package com.Dispather.My.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.Dispather.My.utils.model.UniqueProcessRef;

@Service
public class ProcessManagementImpl implements ProcessManagement
{
	public  UniqueProcessRef createUniqueSequence(Long customerId)
	{
		String uniqueID = UUID.randomUUID().toString();
		String time = getTime();
		return new UniqueProcessRef(uniqueID, customerId, time);
	}

	public  UniqueProcessRef createUniqueSequence()
	{
		return createUniqueSequence(9999999999L);
	}
	
	public UniqueProcessRef UpdateTime(UniqueProcessRef upr)
	{
		upr.setTime(getTime());
		return upr;
	}
	
	private String getTime()
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ss mm HH dd MM yyyy");
		return LocalDateTime.now().format(formatter);
	}
}
