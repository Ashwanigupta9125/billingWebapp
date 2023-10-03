package com.example.billingbackend.controller.BuyingAndSelling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.billingbackend.Service.StockService;
import com.example.billingbackend.dao.ItemBoughtRepostory;
import com.example.billingbackend.dao.ProductsRepository;
import com.example.billingbackend.entities.ItemBought;

@RestController
@RequestMapping("/buy")
public class BuyStock {
	
	@Autowired
	private ItemBoughtRepostory itembought; 
	
	@Autowired
	private StockService service;
	
	@PostMapping("/addstock")
	public void buyDetail(@RequestBody ItemBought itemBought) {	
      
		//during payment we also have to upload payment status
		
		service.CurrentStockUpdate(itemBought.getProduct_id(), itemBought.getQuantity());		
		itembought.save(itemBought);	
		
	}
	

	
	

}
