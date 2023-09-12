package com.example.billingbackend.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table
public class ItemBought {
	
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private int buying_id;
	
//	@OneToOne( cascade=CascadeType.ALL)
//	private List<Seller> seller;
	
//	@OneToOne(cascade=CascadeType.ALL)
//	private List<Products> product;
	
	
	@Column
	private double price_unit;
	
	
	@Column
	private double total_unit_buy;


	@Basic
	private java.sql.Date sqldate;
	
	
	@ManyToOne( cascade=CascadeType.ALL)
	@JoinColumn(name="seller_id")
	private Seller seller;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="product_id")
	private Products product;
	
	



	public ItemBought(Seller seller, Products product, double price_unit, double total_unit_buy) {
		super();
		this.seller = seller;
		this.product = product;
		this.price_unit = price_unit;
		this.total_unit_buy = total_unit_buy;
	}
	


}
