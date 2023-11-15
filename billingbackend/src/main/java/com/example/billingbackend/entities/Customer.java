package com.example.billingbackend.entities;


import jakarta.persistence.Column;
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
	@Column(nullable=false)
	private String customer_name;
	@Column(nullable=false)
	private String customer_phone_no;
	@Column(nullable=false)
	private String address;
	@Column(nullable=false)
	private String city;
	@Column
	private int customer_total_due;
	
	
	public int getCustomer_id() {
		return customer_id;
	}


	public Customer() {
		super();
	}


	public Customer(String customer_name, String customer_phone_no, String address, String city) {
		super();
		this.customer_name = customer_name;
		this.customer_phone_no = customer_phone_no;
		this.address = address;
		this.city = city;
		
	}


	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_phone_no() {
		return customer_phone_no;
	}
	public void setCustomer_phone_no(String customer_phone_no) {
		this.customer_phone_no = customer_phone_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getCustomer_total_due() {
		return customer_total_due;
	}
	public void setCustomer_total_due(int customer_total_due) {
		this.customer_total_due = customer_total_due;
	}
	
	
	

}
