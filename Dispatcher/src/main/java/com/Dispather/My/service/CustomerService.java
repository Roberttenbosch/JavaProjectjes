package com.Dispather.My.service;

import java.util.List;

import com.Dispather.My.utils.model.UniqueProcessRef;
import com.Dispather.My.web.bean.CustomerBean;

public interface CustomerService
{
	public void SaveCustomer(CustomerBean customerBean, UniqueProcessRef upr);
	
	public long countCustomers();
	
	public void saveCustomers(List<CustomerBean> beans);
	
	public List<CustomerBean> getAllCustomers();
}
