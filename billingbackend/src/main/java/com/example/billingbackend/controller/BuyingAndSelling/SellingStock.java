package com.example.billingbackend.controller.BuyingAndSelling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.billingbackend.dao.ItemSellingRepository;
import com.example.billingbackend.entities.ItemSelling;

@RestController
@RequestMapping("/sell")
public class SellingStock {
	
	@Autowired
	private ItemSellingRepository itemSellingRepository;
	
	@PostMapping("/selling")
	public void itemSelling(@RequestBody ItemSelling itemSelling) {
		
		itemSellingRepository.save(itemSelling);
	}

}
