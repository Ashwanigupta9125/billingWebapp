package com.example.billingbackend.controller.BuyingAndSelling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.billingbackend.Service.StockService;
import com.example.billingbackend.dao.ItemSellingRepository;
import com.example.billingbackend.entities.ItemSelling;

@RestController
@RequestMapping("/lock/sell")
public class SellingStock {
	
	@Autowired
	private ItemSellingRepository itemSellingRepository;
	@Autowired
	private StockService service;
	
	@PostMapping("/selling")
	public void itemSelling(@RequestBody ItemSelling itemSelling) {
		
		//during payment we also have to upload payment status
		
		double negative_stock=(-1.0)*itemSelling.getQuantity();
		service.CurrentStockUpdate(itemSelling.getProduct_id(),negative_stock );
		itemSellingRepository.save(itemSelling);
	}

}
