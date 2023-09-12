package com.example.billingbackend.entities;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Customer {
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private int customer_id;
	
	
	private String customer_name;
	private Long customer_phone_no;
	private String address;
	private String customer_total_due;
	public Customer(String customer_name, Long customer_phone_no, String address, String customer_total_due) {
		super();
		this.customer_name = customer_name;
		this.customer_phone_no = customer_phone_no;
		this.address = address;
		this.customer_total_due = customer_total_due;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public Long getCustomer_phone_no() {
		return customer_phone_no;
	}
	public void setCustomer_phone_no(Long customer_phone_no) {
		this.customer_phone_no = customer_phone_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCustomer_total_due() {
		return customer_total_due;
	}
	public void setCustomer_total_due(String customer_total_due) {
		this.customer_total_due = customer_total_due;
	}
	

}
