package com.example.billingbackend.dao;


import org.springframework.data.repository.CrudRepository;
import com.example.billingbackend.entities.Products;


public interface ProductsRepository extends CrudRepository< Products,Integer>{

	
}

