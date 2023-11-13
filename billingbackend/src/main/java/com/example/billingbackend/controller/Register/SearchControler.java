package com.example.billingbackend.controller.Register;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.billingbackend.dao.CustomerRepository;
import com.example.billingbackend.dao.ProductsRepository;
import com.example.billingbackend.dao.SellerRepository;
import com.example.billingbackend.entities.Products;
import com.example.billingbackend.entities.Seller;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/lock/Search")
public class SearchControler {
	
	
	
	//Product Search ...................
	@Autowired
	private ProductsRepository productsRepository;
	
	 @GetMapping("/p/{name}")
	 public List<String> getNameSearch(@PathVariable String name) {
		 
		 List<String> products= productsRepository.FindBySearchName(name);
		 System.out.println(products);
		 return products;
	 }
	 @GetMapping("/p/")
	 public String getNameSearch() {
		 return " ";
	 }
	 
	 
	   //Seller serach
	 
	 
		@Autowired
		private SellerRepository sellerRepository;
		
		 @GetMapping("/s/{name}")
		 public List<String> getNameSearchSeller(@PathVariable String name) {
			 
			 List<String> seller= sellerRepository.FindBySearchName(name);
			 System.out.println(seller);
			 return seller;
		 }
		 @GetMapping("/s/")
		 public String getNameSearchSeller() {
			 return " ";
		 }
		 
		 
		   //Customr serach
		 
		 
			@Autowired
			private CustomerRepository customerRepository;
			
			 @GetMapping("/c/{name}")
			 public List<String> getNameSearchCustomer(@PathVariable String name) {
				 
				 List<String> customer= customerRepository.FindBySearchName(name);
				 System.out.println(customer);
				 return customer;
			 }
			 @GetMapping("/c/")
			 public String getNameSearchCustomer() {
				 return " ";
			 }

}
