package com.example.billingbackend.entities;

import java.util.List;

import org.apache.tomcat.util.security.PrivilegedSetAccessControlContext;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Seller {
	
	public Seller(String seller_name, String seller_phone_no, String address) {
		super();
		this.seller_name = seller_name;
		this.seller_phone_no = seller_phone_no;
		this.address = address;
	}
	
	

	
	
	public Seller(int seller_id, String seller_name, String seller_phone_no, String address) {
		super();
		this.seller_id = seller_id;
		this.seller_name = seller_name;
		this.seller_phone_no = seller_phone_no;
		this.address = address;
	}





	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private int seller_id;
	
	@Column
	private String seller_name;
	@Column
	private String seller_phone_no;

	@Column
	private String address;
	
	//@ManyToOne(cascade = CascadeType.ALL) 
	//private Products products;
 

	@OneToMany(mappedBy = "seller",cascade=CascadeType.ALL)
	private List<ItemBought> itemBoughts;
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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



}
