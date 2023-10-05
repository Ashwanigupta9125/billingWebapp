package com.example.billingbackend.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.billingbackend.entities.ItemSelling;

@Repository
public interface ItemSellingRepository extends JpaRepository<ItemSelling, Integer>{

	
	@Query(value ="select * from item_selling where date =:date",nativeQuery = true)
	public List<ItemSelling>  FindTransitionOfBuy(@Param("date") LocalDate date);
	
	@Query(value ="select * from item_selling where date BETWEEN :startDate AND :endDate",nativeQuery = true)
	public List<ItemSelling>  FindTransitionOfBuyBtw(@Param("startDate") LocalDate startDate,@Param("endDate") LocalDate endDate);
	
}
