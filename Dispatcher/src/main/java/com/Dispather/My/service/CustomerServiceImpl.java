package com.Dispather.My.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dispather.My.Rest.CustomerRequestController;
import com.Dispather.My.model.Customer;
import com.Dispather.My.repository.CustomerRepository;
import com.Dispather.My.utils.model.UniqueProcessRef;
import com.Dispather.My.web.bean.CustomerBean;

@Service
public class CustomerServiceImpl implements CustomerService
{
	private static final Logger log = LoggerFactory
			.getLogger(CustomerRequestController.class);
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public void SaveCustomer(CustomerBean customerBean, UniqueProcessRef upr)
	{
		Customer cus = new Customer();
		cus.setName(customerBean.getName());
		cus.setPhoneNumber(customerBean.getPhoneNumber());
		
		log.info("Saving customer {}", customerBean.toString());
		log.info(upr.toString());
		cus.setProcessRef(upr.toString());
		
		customerRepository.save(cus);
		log.info("Saved customer {}", customerBean.toString());
		
	}
	
	public long countCustomers() {
		return customerRepository.count();
	}
	
	public void saveCustomers(List<CustomerBean>customerBeans)
	{
		List<Customer> customers = new ArrayList<>(30);
		for(CustomerBean customerBean : customerBeans)
		{
			customers.add(getCustomer(customerBean));
		}
		customerRepository.saveAll(customers);
	}
	
		
	public List<CustomerBean> getAllCustomers()
	{
		List<CustomerBean> customerBeans =  new ArrayList<>(30);
		for(Customer customer: customerRepository.findAll())
		{
			customerBeans.add(getCustomerBean(customer));
		}
		return customerBeans;
	}
	
	private Customer getCustomer(CustomerBean bean)
	{
		Customer cus = new Customer();
		cus.setName(bean.getName());
		cus.setPhoneNumber(bean.getPhoneNumber());
		return cus;
	}

	
	private CustomerBean getCustomerBean(Customer customer)
	{
		return new CustomerBean(customer.getName(), customer.getPhoneNumber());
	}
}
