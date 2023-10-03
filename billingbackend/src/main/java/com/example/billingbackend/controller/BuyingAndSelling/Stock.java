package com.example.billingbackend.controller.BuyingAndSelling;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.billingbackend.dao.ProductsRepository;
import com.example.demo.Entity.Products;


@RestController
@RequestMapping("/currentStock")
public class Stock {
	
	@Autowired
	private ProductsRepository productsRepository;

	@GetMapping("/{id}")
	public double getCurrentStock(@PathVariable int id) {
		
		try {
			return  productsRepository.findById(id).get().getAvailable_stock();
		}catch (Exception e) {			
			System.out.print("Don't receved any value ################");
		
		}
		return 0;
     }

    }
