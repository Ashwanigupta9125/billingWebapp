package com.example.billingbackend.entities;

import java.util.List;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table
public class Products {
	
	


	@Id
	
    @GeneratedValue(strategy= GenerationType.AUTO)
	private int product_id;
	
	@Column(unique=true)
	@NonNull
	private String product_name;
	

	
	@OneToMany(mappedBy = "product",cascade=CascadeType.ALL)
	private List<ItemBought> itemBoughts;
	

	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	
	public Products(String product_name) {
		super();
		this.product_name = product_name;
	}


}
