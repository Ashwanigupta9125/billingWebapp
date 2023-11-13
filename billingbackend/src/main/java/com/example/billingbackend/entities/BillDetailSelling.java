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
public class BillDetailSelling {

	
	@Id	
    @GeneratedValue(strategy= GenerationType.AUTO)
	private int Invoice_id;
	
	@Column(nullable=false)
	private int Customer_id;
	
	
	@Column()
	private double TotalAmount;
	
	@Column()
	private double TaxRate;
	
	@Column()
	private double Discount;
	


	@JsonFormat(pattern = "yyyy-mm-dd",shape = Shape.NUMBER_INT)
	@CreationTimestamp(source = SourceType.DB)	
	private LocalDate date;



	public BillDetailSelling(int customer_id) {
		super();
		Customer_id = customer_id;
	}



	public BillDetailSelling() {
		super();
		// TODO Auto-generated constructor stub
	}



	public BillDetailSelling(int invoice_id, int customer_id, double totalAmount, double taxRate, double discount,
			LocalDate date) {
		super();
		Invoice_id = invoice_id;
		Customer_id = customer_id;
		TotalAmount = totalAmount;
		TaxRate = taxRate;
		Discount = discount;
		this.date = date;
	}




	public int getInvoice_id() {
		return Invoice_id;
	}



	public int getCustomer_id() {
		return Customer_id;
	}



	public void setCustomer_id(int customer_id) {
		Customer_id = customer_id;
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



	public LocalDate getDate() {
		return date;
	}





	
}
