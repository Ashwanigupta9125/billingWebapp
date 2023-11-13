package com.example.billingbackend.controller.Register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.billingbackend.dao.CustomerRepository;
import com.example.billingbackend.dao.ProductsRepository;
import com.example.billingbackend.dao.SellerRepository;
import com.example.billingbackend.entities.Customer;
import com.example.billingbackend.entities.Products;
import com.example.billingbackend.entities.Seller;

@RestController
@RequestMapping("/lock/register")
public class Register {
	
	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProductsRepository productsRepository;
	
	
	@PostMapping("/seller")
	private void AddSeller(@RequestBody Seller seller) {
		
		sellerRepository.save(seller);
	}
	
	@PostMapping("/customer")
	private void AddSeller(@RequestBody Customer customer) {
		
		customerRepository.save(customer);
	}
	
	@PostMapping("/product")
	private void AddSeller(@RequestBody Products products) {
		System.out.print(products);
		productsRepository.save(products);
	}
	
	

}
