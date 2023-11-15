package com.example.billingbackend.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Seller {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int seller_id;
	
	@Column(nullable=false)
	private String seller_name;
	@Column(nullable=false)
	private String seller_phone_no;
	@Column(nullable=false)
	private String address;
	@Column(nullable=false)
	private String city;	
	@Column
	private int payment_due;

	
	public Seller() {
		super();
	}

	public Seller(String seller_name, String seller_phone_no, String address, String city) {
		super();
		this.seller_name = seller_name;
		this.seller_phone_no = seller_phone_no;
		this.address = address;
		this.city = city;
		
	}

	public String getSeller_name() {
		return seller_name;
	}

	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}

	public String getSeller_phone_no() {
		return seller_phone_no;
	}

	public void setSeller_phone_no(String seller_phone_no) {
		this.seller_phone_no = seller_phone_no;
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

	public int getPaymrnt_due() {
		return payment_due;
	}

	public void setPaymrnt_due(int paymrnt_due) {
		this.payment_due = paymrnt_due;
	}

	public int getSeller_id() {
		return seller_id;
	}

	

}
