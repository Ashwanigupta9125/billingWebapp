package com.example.billingbackend.controller.Register;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.billingbackend.dao.CustomerRepository;
import com.example.billingbackend.dao.SellerRepository;
import com.example.billingbackend.entities.Customer;
import com.example.billingbackend.entities.Seller;


@RestController
@RequestMapping("/lock/c_detail")
public class CustomerDetail {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	 @GetMapping("/{id}")
	 public Optional<Customer> getDetailBySellerId(@PathVariable int id) {
		 Optional<Customer> customer=customerRepository.findById(id);
		 return customer;
		 
	 }
	 
	 @GetMapping("/c/{sellername}")
	 public Optional<Customer> getDetailByCustomerName(@PathVariable String sellername) {
		 Optional<Customer> customer=Optional.of(customerRepository.findbycustomer_name(sellername));
		 return customer;
		 
	 }

}
