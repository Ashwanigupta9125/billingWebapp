package com.example.billingbackend.controller.BuyingAndSelling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.billingbackend.dao.ItemBoughtRepostory;
import com.example.billingbackend.entities.ItemBought;

@RestController
@RequestMapping("/buy")
public class BuyStock {
	
	@Autowired
	private ItemBoughtRepostory itembought; 
	
	
	@PostMapping("/addstock")
	public void buyDetail(@RequestBody ItemBought itemBought) {	
		itembought.save(itemBought);	
	}
	

	
	

}
