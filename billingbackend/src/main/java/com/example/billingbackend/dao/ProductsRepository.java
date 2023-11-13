  package com.example.billingbackend.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.billingbackend.entities.Products;

import org.springframework.transaction.annotation.Transactional;


@Repository
public interface ProductsRepository extends JpaRepository< Products,Integer>{

	@Modifying(clearAutomatically=true)
	@Transactional
	@Query(value ="UPDATE Products p SET p.available_stock=:stock WHERE p.product_id=:id",nativeQuery = true)
	Integer UpdateStock(@Param("stock") double stock,@Param("id") int id);
	
	
	@Query(value ="SELECT product_name FROM Products where product_name like %:name% limit 5;",nativeQuery = true)
	List<String> FindBySearchName(@Param("name") String name);


}