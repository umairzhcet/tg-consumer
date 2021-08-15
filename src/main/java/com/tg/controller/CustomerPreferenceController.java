package com.tg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tg.entity.CustomerEntity;
import com.tg.service.CustomerService;

@RestController
public class CustomerPreferenceController {
	
	@Autowired
	CustomerService customerService; 
	
	@GetMapping("/all")  
	private List<CustomerEntity> getAllCustomers()   
	{  
		return customerService.getCustomerPreferences();
		
	}
	
	@GetMapping("/customer/{id}")
	private CustomerEntity getCustomer(@PathVariable("id") long id)   
	{  
		return customerService.getCustomerPreferencesById(id);
	}  

}
