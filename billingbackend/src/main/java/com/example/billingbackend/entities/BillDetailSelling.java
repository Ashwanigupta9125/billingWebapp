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
	private int Seller_id;
	
	
	@JsonFormat(pattern = "yyyy-mm-dd",shape = Shape.NUMBER_INT)
	@CreationTimestamp(source = SourceType.DB)	
	private LocalDate date;
}
