package com.example.billingbackend.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.billingbackend.entities.Seller;


@Repository
public interface SellerRepository extends JpaRepository< Seller,Integer> {

	
	@Query(value ="select * from Seller where seller_name =:name",nativeQuery = true)
	public Seller  findbyseller_name(@Param("name") String name);
	
    	
}
