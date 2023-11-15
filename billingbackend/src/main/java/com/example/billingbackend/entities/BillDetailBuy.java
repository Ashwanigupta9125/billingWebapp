package com.example.billingbackend.entities;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class BillDetailBuy {
	
	@Override
	public String toString() {
		return "BillDetailBuy [Invoice_id=" + Invoice_id + ", seller_id=" + seller_id + ", TotalAmount=" + TotalAmount
				+ ", date=" + date + "]";
	}

	@Id	
    @GeneratedValue(strategy= GenerationType.AUTO)
	private int Invoice_id;
	
	@Column(nullable=false)
	private int seller_id;
	
	@Column()
	private double TotalAmount;
	
	@Column()
	private double TaxRate;
	
	@Column()
	private double Discount;
	
	@JsonFormat(pattern = "yyyy-mm-dd",shape = Shape.NUMBER_INT)
	@CreationTimestamp(source = SourceType.DB)	
	private LocalDate date;

	
	
	public BillDetailBuy(int seller_id) {
		super();
		this.seller_id = seller_id;
	}



	public BillDetailBuy(int invoice_id, int seller_id, LocalDate date) {
		super();
		this.Invoice_id = invoice_id;
		this.seller_id = seller_id;
		this.date = date;
	}



	public int getInvoice_id() {
		return Invoice_id;
	}



	public BillDetailBuy(int invoice_id, int seller_id, double totalAmount, double taxRate, double discount,
			LocalDate date) {
		super();
		Invoice_id = invoice_id;
		this.seller_id = seller_id;
		TotalAmount = totalAmount;
		TaxRate = taxRate;
		Discount = discount;
		this.date = date;
	}



	public double getTotalAmount() {
		return TotalAmount;
	}



	public void setTotalAmount(double totalAmount) {
		TotalAmount = totalAmount;
	}



	public double getTaxRate() {
		return TaxRate;
	}



	public void setTaxRate(double taxRate) {
		TaxRate = taxRate;
	}



	public double getDiscount() {
		return Discount;
	}



	public void setDiscount(double discount) {
		Discount = discount;
	}



	public int getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}

	public LocalDate getDate() {
		return date;
	}



}
