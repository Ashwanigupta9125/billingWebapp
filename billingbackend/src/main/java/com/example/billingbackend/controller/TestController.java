package com.example.billingbackend.controller;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Check;
import org.slf4j.helpers.CheckReturnValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.billingbackend.Service.UserDetailService;
import com.example.billingbackend.dao.ItemBoughtRepostory;
import com.example.billingbackend.dao.ProductsRepository;
import com.example.billingbackend.dao.SellerRepository;
import com.example.billingbackend.dao.UserDetailRepostory;
import com.example.billingbackend.dao.UserDetailrepo;
import com.example.billingbackend.entities.AdminDetail;
import com.example.billingbackend.entities.ItemBought;
import com.example.billingbackend.entities.Products;
import com.example.billingbackend.entities.Seller;
import com.example.billingbackend.entities.UserDetail;

import ch.qos.logback.core.model.Model;
import test.Testrepocrud;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/lock")
public class TestController {
	
//	@Autowired
//	private ProductsRepository userrepo;
//
//
//	@Autowired
//	private SellerRepository sellerRepository;
//	
//	
//	@Autowired
//	private ItemBoughtRepostory itemBoughtRepostory;
	
	
//	@Autowired
//	private UserDetailrepo userDetailrepo;
	
	//@Autowired
	//private UserDetailService ueserserService;
	
	//Products product01=new Products("toy015");

	//UserDetail user_detail=new UserDetail("ash", "ash");
	
	//ItemBought iemBought=new ItemBought(7, 7, 7, 10);	
	@Autowired
	public ProductsRepository productsRepository;
	

	@GetMapping("/check01")
	public void check01() {
		
		System.out.print("runnig check01..........................");
		
		//productsRepository.UpdateStock(1205,53);
		
	}
	
	
	@GetMapping("/test")
	private String index() {
	
		System.out.print("Method is stared.............");

		return "Request completed........";
		
		
	}
	
	

	

}
