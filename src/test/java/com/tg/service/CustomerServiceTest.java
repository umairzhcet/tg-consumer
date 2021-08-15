package com.tg.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.tg.entity.CustomerEntity;

@SpringBootTest
class CustomerServiceTest {
	
	@Autowired
	private CustomerService customerService;
	
	@MockBean
	private RestTemplate restTemplate;

	@Test
	void testGetCustomerPreferences() {
		
		CustomerEntity c1=new CustomerEntity(1,"cus1","abc@gmail.com","12345","sms");
		CustomerEntity c2=new CustomerEntity(2,"cus2","xyz@gmail.com","12346","phone");
		ArrayList<CustomerEntity> list=new ArrayList<>();
		list.add(c1);
		list.add(c2);
		
        ResponseEntity<List<CustomerEntity>> myEntity = new ResponseEntity<List<CustomerEntity>>(list,HttpStatus.ACCEPTED);

		
		when(restTemplate.exchange(
				ArgumentMatchers.anyString(),
				ArgumentMatchers.eq(HttpMethod.GET),
				ArgumentMatchers.<HttpEntity<?>> any(),
				ArgumentMatchers.<ParameterizedTypeReference<List<CustomerEntity>>>any())
	        ).thenReturn(myEntity);
		
			List<CustomerEntity> response=customerService.getCustomerPreferences();
			assertNotNull(response);

				
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	void testGetCustomerPreferencesById() {
		
		CustomerEntity c1=new CustomerEntity(1,"cus1","abc@gmail.com","12345","sms");
		
        ResponseEntity<CustomerEntity> myEntity = new ResponseEntity<CustomerEntity>(c1,HttpStatus.ACCEPTED);

		
		when(restTemplate.getForEntity(
				ArgumentMatchers.anyString(),
				ArgumentMatchers.any(Class.class),
				ArgumentMatchers.anyLong()
				
	        )).thenReturn(myEntity);
		
			CustomerEntity response=customerService.getCustomerPreferencesById(1L);
			assertNotNull(response);

				
		
	}


}
