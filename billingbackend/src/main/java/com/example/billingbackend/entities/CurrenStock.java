package com.example.billingbackend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class CurrenStock {
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private int current_stock_id;
	
	@OneToOne
	private Products product_name;
    
	public CurrenStock(Products product_name) {
		super();
		this.product_name = product_name;
	}

	@Column
	private double available_stock;

	public double getAvailable_stock() {
		return available_stock;
	}

	public void setAvailable_stock(double available_stock) {
		this.available_stock = available_stock;
	}

}
