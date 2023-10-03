package com.example.billingbackend.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table
public class Products {
	
	


	@Id	
    @GeneratedValue(strategy= GenerationType.AUTO)
	private int product_id;
	@Column(nullable=false)
	private String product_name;
	@Column(nullable=false)
	private String product_catagory;
	@Column
	private int available_stock;
	
	

	


	public Products() {
		super();
	}

	public Products(String product_name, String product_catagory) {
		super();
		this.product_name = product_name;
		this.product_catagory = product_catagory;
	}

	public int getProduct_id() {
		return product_id;
	}


	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_catagory() {
		return product_catagory;
	}

	public void setProduct_catagory(String product_catagory) {
		this.product_catagory = product_catagory;
	}

	public int getAvailable_stock() {
		return available_stock;
	}

	public void setAvailable_stock(int available_stock) {
		this.available_stock = available_stock;
	}

	@Override
	public String toString() {
		return "Products [product_id=" + product_id + ", product_name=" + product_name + ", product_catagory="
				+ product_catagory + ", available_stock=" + available_stock + "]";
	}

	



	





}
