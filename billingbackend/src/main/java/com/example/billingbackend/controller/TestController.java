package com.example.billingbackend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.billingbackend.dao.ItemBoughtRepostory;
import com.example.billingbackend.dao.ProductsRepository;
import com.example.billingbackend.dao.SellerRepository;
import com.example.billingbackend.entities.ItemBought;
import com.example.billingbackend.entities.Products;
import com.example.billingbackend.entities.Seller;

import test.Testrepocrud;




@RestController
public class TestController {
	
	@Autowired
	private ProductsRepository userrepo;


	@Autowired
	private SellerRepository sellerRepository;
	
	
	@Autowired
	private ItemBoughtRepostory itemBoughtRepostory;

	
	
	
	Seller seller01=new Seller("ash05", "54156154186", "gfuhgfgashd ashjbd js");
	Products product01=new Products("toy010");
	Seller seller02=new Seller("ash010", "54156154186", "gfuhgfgashd ashjbd js");
	Products product02=new Products("toy015");
	
	
    ItemBought itemBought01=new ItemBought(seller02,product02,100 , 1000);
  //  ItemBought itemBought02=new ItemBought(seller01,product01,100 , 1000);
  //  ItemBought itemBought03=new ItemBought(seller01,product01,100 , 1000);
  //  ItemBought itemBought04=new ItemBought(seller02,product02,100 , 1000);
  //  ItemBought itemBought05=new ItemBought(seller02,product02,100 , 1000);
   // ItemBought itemBought06=new ItemBought(seller02,product02,100 , 1000);
    //ItemBought itemBought07=new ItemBought(seller02,product01,100 , 1000);
 
	
	@GetMapping("/test")
	public String index() {
			
		//sellerRepository.save(seller01);
		//userrepo.save(product01);
		itemBoughtRepostory.save(itemBought01);
		//itemBoughtRepostory.save(itemBought02);
		//itemBoughtRepostory.save(itemBought03);
		//itemBoughtRepostory.save(itemBought04);
//		itemBoughtRepostory.save(itemBought05);
//		itemBoughtRepostory.save(itemBought06);
//		itemBoughtRepostory.save(itemBought07);
		
		System.out.println("heloooooooooooooo");
		return "test";
		
	}
	

}
