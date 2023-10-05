package com.example.billingbackend.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.billingbackend.entities.ItemBought;
import com.example.billingbackend.entities.Seller;

@Repository
public interface ItemBoughtRepostory extends JpaRepository< ItemBought,Integer>{
	
	@Query(value ="select * from item_bought where date =:date",nativeQuery = true)
	public List<ItemBought>  FindTransitionOfBuy(@Param("date") LocalDate date);
	
	@Query(value ="select * from item_bought where date BETWEEN :startDate AND :endDate",nativeQuery = true)
	public List<ItemBought>  FindTransitionOfBuyBtw(@Param("startDate") LocalDate startDate,@Param("endDate") LocalDate endDate);
	
	

}
