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
public class ItemSelling {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private int selling_id;
	
	@Column(nullable=false)
	private int product_id;	
	
	@Column(nullable=false)
	private double price_unit;
	
	@Column(nullable=false)
	private double quantity;
	
	@Column(nullable=false)
	private String unit;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Invoice_id")
	private BillDetailSelling invoice_id;
	
	@JsonFormat(pattern = "yyyy-mm-dd",shape = Shape.NUMBER_INT)
	@CreationTimestamp(source = SourceType.DB)	
	private LocalDate date;

	public LocalDate getDate() {
		return date;
	}

	
	
	public ItemSelling(int product_id, double price_unit, double quantity, String unit, BillDetailSelling invoice_id) {
		super();
		this.product_id = product_id;
		this.price_unit = price_unit;
		this.quantity = quantity;
		this.unit = unit;
		this.invoice_id = invoice_id;
	}

	public ItemSelling() {
		super();
	}

	public int getSelling_id() {
		return selling_id;
	}

	public void setSelling_id(int selling_id) {
		this.selling_id = selling_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
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

	public BillDetailSelling getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(BillDetailSelling invoice_id) {
		this.invoice_id = invoice_id;
	}

    
	

}
