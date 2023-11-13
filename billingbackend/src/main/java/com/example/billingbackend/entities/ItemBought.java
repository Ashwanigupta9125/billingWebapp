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
	private double price_unit;
	
	@Column(nullable=false)
	private double quantity;
	
	@Column(nullable=false)
	private String unit;
	
	@ManyToOne()
	@JoinColumn(name="Invoice_id")
	private BillDetailBuy invoice_id;
	
	

	public ItemBought(int product_id, double price_unit, double quantity, String unit) {
		super();
		this.product_id = product_id;
		this.price_unit = price_unit;
		this.quantity = quantity;
		this.unit = unit;
	}

	public ItemBought(int product_id, double price_unit, double quantity, String unit, BillDetailBuy invoice_id) {
		super();
		this.product_id = product_id;
		this.price_unit = price_unit;
		this.quantity = quantity;
		this.unit = unit;
		this.invoice_id = invoice_id;
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

	public BillDetailBuy getInvoice_id() {
		return invoice_id;
	}

	@Override
	public String toString() {
		return "ItemBought [buying_id=" + buying_id + ", product_id=" + product_id + ", price_unit=" + price_unit
				+ ", quantity=" + quantity + ", unit=" + unit + ", invoice_id=" + invoice_id.toString() + "]";
	}

	public void setInvoice_id(BillDetailBuy invoice_id) {
		this.invoice_id = invoice_id;
	}

//	@JsonFormat(pattern = "yyyy-mm-dd",shape = Shape.NUMBER_INT)
//	@CreationTimestamp(source = SourceType.DB)	
//	private LocalDate date;
//
//	public LocalDate getDate() {
//		return date;
//	}
//
//	



}
