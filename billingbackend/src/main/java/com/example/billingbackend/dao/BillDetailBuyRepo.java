package com.example.billingbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.billingbackend.entities.BillDetailBuy;


public interface BillDetailBuyRepo  extends JpaRepository<BillDetailBuy,Integer>{

	
	@Query(value ="select * from bill_detail_buy_seq",nativeQuery = true)
	public int FindNextGeneratedValue();
	
}
