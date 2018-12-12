package com.Dispather.My.Rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Dispather.My.Rest.Bean.CustomerCountBean;
import com.Dispather.My.service.CustomerService;
import com.Dispather.My.utils.ProcessManagement;
import com.Dispather.My.web.bean.CustomerBean;

@RestController("/api/")
public class CustomerRequestController
{
	private static final Logger log = LoggerFactory.getLogger(CustomerRequestController.class);

	@Autowired
	private CustomerService		costumerService;
	
	@Autowired
	private ProcessManagement processManagement;
	
	@GetMapping("/getCustomersCount")
	public CustomerCountBean getCustomersCount()
	{
		return new CustomerCountBean(costumerService.countCustomers(), "Customers");
	}
	
	@GetMapping("/getCustomersAll")
	public List<CustomerBean> getCustomersAll()
	{
		return costumerService.getAllCustomers();
	}
	
	@PostMapping("/getBackUpCustomersDatabase")
	public void saveAlleCustomers(@RequestBody List<CustomerBean> customers)
	{
		costumerService.saveCustomers(customers);
	}
}

