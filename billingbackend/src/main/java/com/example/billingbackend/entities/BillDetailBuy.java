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

	@Id	
    @GeneratedValue(strategy= GenerationType.AUTO)
	private int Invoice_id;
	
	@Column(nullable=false)
	private int Customer_id;
	
	
	@JsonFormat(pattern = "yyyy-mm-dd",shape = Shape.NUMBER_INT)
	@CreationTimestamp(source = SourceType.DB)	
	private LocalDate date;

	public BillDetailBuy(int customer_id) {
		super();
		Customer_id = customer_id;
	}

	public int getInvoice_id() {
		return Invoice_id;
	}

	public void setInvoice_id(int invoice_id) {
		Invoice_id = invoice_id;
	}

	public int getCustomer_id() {
		return Customer_id;
	}

	public void setCustomer_id(int customer_id) {
		Customer_id = customer_id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}


	
}
