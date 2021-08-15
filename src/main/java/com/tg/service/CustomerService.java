package com.tg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tg.entity.CustomerEntity;

@Service
public class CustomerService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value( "${customer.preferences.all}")
	String uriAllPreferences = "http://localhost:8080/customer";
	
	@Value( "${customer.preferences.id}")
	String uriCustomerPreference = "http://localhost:8080/customer";
	
	public List<CustomerEntity> getCustomerPreferences() {

		ResponseEntity<List<CustomerEntity>> response = restTemplate.exchange(uriAllPreferences, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<CustomerEntity>>() {
				});
		return response.getBody();
	}
	
	public CustomerEntity getCustomerPreferencesById(Long id) {

		ResponseEntity<CustomerEntity> customerList=restTemplate.getForEntity(uriCustomerPreference, CustomerEntity.class,id); 
		return customerList.getBody();
	}

}
