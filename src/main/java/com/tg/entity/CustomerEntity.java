package com.tg.entity;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerEntity {
	@Id
	@Column
	private long cust_id;
	
	@Column
	String cust_name;
	
	@Column
	String cust_email;
	
	@Column
	String cust_phone;
	
	@Column
	String cust_mktng_preference;

}
