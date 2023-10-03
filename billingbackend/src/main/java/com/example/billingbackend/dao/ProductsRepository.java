  package com.example.billingbackend.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.billingbackend.entities.Products;

import jakarta.transaction.Transactional;


@Repository
public interface ProductsRepository extends JpaRepository< Products,Integer>{

	@Modifying
	@Transactional
	@Query(value ="UPDATE Products p SET p.available_stock=:stock WHERE p.product_id=:id",nativeQuery = true)
	void UpdateStock(@Param("stock") double stock,@Param("id") int id);

	
}

