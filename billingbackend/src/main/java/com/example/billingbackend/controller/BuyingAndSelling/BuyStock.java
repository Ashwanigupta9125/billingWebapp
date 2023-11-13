package com.example.billingbackend.controller.BuyingAndSelling;

import java.util.List;

import org.antlr.v4.runtime.atn.AmbiguityInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.example.billingbackend.Service.StockService;
import com.example.billingbackend.dao.BillDetailBuyRepo;
import com.example.billingbackend.dao.ItemBoughtRepostory;
import com.example.billingbackend.dao.NextValue;

import com.example.billingbackend.entities.BillDetailBuy;
import com.example.billingbackend.entities.ItemBought;


@RestController
@RequestMapping("/lock/buy")
public class BuyStock {
	
	@Autowired
	private ItemBoughtRepostory itembought; 
	
	@Autowired
	private StockService service;
	

	
	
	
	
	@GetMapping("/addstocktest")
	public String buyDetail() {	
      
	 return "i am working api";
		
	}
	
	

	@PostMapping("/addstock")
	public List<ItemBought> buyDetail(@RequestBody List<ItemBought> itemBought) {	
      
		//Ckeck seller is present or not
		
		
				
		BillDetailBuy billDetailBuyObj=service.getBillInvoiceNo(itemBought.get(0).getInvoice_id().getSeller_id());
		
		for(ItemBought itemadd: itemBought ) {
		
			
			//during payment we also have to upload payment status
    
            
			service.CurrentStockUpdate(itemadd.getProduct_id(), itemadd.getQuantity());	
			System.out.println("check current stock update");
			//System.out.println(billDetailBuyObj.toString());
			itemadd.setInvoice_id(billDetailBuyObj);
		}		
			
		
		List<ItemBought> itemBoughts= itembought.saveAll(itemBought);	

		
		return itemBoughts;
	}
	

	
	

}
