package com.example.billingbackend.entities;



import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table
public class ItemBought {
	
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private int buying_id;
	@Column(nullable=false)
	private int product_id;	
	@Column(nullable=false)
	private int seller_id;
	@Column(nullable=false)
	private double price_unit;
	@Column(nullable=false)
	private double quantity;	
	@Column(nullable=false)
	private String unit;
	@Column
	private int payment_done;
	@Column
	private Boolean payment_status;
	
	@JsonFormat(pattern = "yyyy-mm-dd",shape = Shape.NUMBER_INT)
	@CreationTimestamp(source = SourceType.DB)	
	private LocalDate date;

	
	

	
	public ItemBought(int product_id, int seller_id, double price_unit, double quantity, String unit, int payment_done) {
		super();
		this.product_id = product_id;
		this.seller_id = seller_id;
		this.price_unit = price_unit;
		this.quantity = quantity;
		this.unit = unit;
		this.payment_done = payment_done;
	
	}



	public ItemBought() {
		super();
	}


	
	public int getBuying_id() {
		return buying_id;
	}



	public int getProduct_id() {
		return product_id;
	}



	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}



	public int getSeller_id() {
		return seller_id;
	}



	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}



	public double getPrice_unit() {
		return price_unit;
	}



	public void setPrice_unit(double price_unit) {
		this.price_unit = price_unit;
	}



	public double getQuantity() {
		return quantity;
	}



	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}



	public String getUnit() {
		return unit;
	}



	public void setUnit(String unit) {
		this.unit = unit;
	}



	public int getPayment_done() {
		return payment_done;
	}



	public void setPayment_done(int payment_done) {
		this.payment_done = payment_done;
	}



	public Boolean getPayment_status() {
		return payment_status;
	}



	public void setPayment_status(Boolean payment_status) {
		this.payment_status = payment_status;
	}



	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
	}

	

	
//	@JsonFormat(pattern = "yyyy-mm-dd",shape = Shape.NUMBER_INT)
//	@UpdateTimestamp(source = SourceType.DB)
//	private Instant lastUpdatedOn;
	
   


}
