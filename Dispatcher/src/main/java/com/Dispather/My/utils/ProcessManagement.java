package com.Dispather.My.utils;

import com.Dispather.My.utils.model.UniqueProcessRef;

public interface ProcessManagement
{
	public  UniqueProcessRef createUniqueSequence();
	public  UniqueProcessRef createUniqueSequence(Long customerId);
}
