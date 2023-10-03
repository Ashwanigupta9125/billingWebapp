package com.example.billingbackend.controller.Register;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.billingbackend.dao.SellerRepository;
import com.example.billingbackend.entities.Seller;

@RestController
@RequestMapping("/s_detail")
public class SellerDetail {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	 @GetMapping("/{id}")
	 public Optional<Seller> getDetailBySellerId(@PathVariable int id) {
		 Optional<Seller> seller=sellerRepository.findById(id);
		 return seller;
		 
	 }
	 
	 @GetMapping("/n/{sellername}")
	 public Optional<Seller> getDetailBySellerName(@PathVariable String sellername) {
		 Optional<Seller> seller=Optional.of(sellerRepository.findbyseller_name(sellername));
		 return seller;
		 
	 }

}
