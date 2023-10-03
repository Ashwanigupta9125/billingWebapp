package com.example.billingbackend.controller;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Check;
import org.slf4j.helpers.CheckReturnValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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




@RestController
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
		Optional<Products> p1=productsRepository.findById(53);
		System.out.print( p1.get().getProduct_name());
		productsRepository.UpdateStock(1205,53);
		
	}
	
	@GetMapping("/test")
	private String index() {
	
		System.out.print("Method is stared.............");
     //	Optional<UserDetail> l1 =ueserserService.gettingDetail();
//		System.out.print("request send is complet.............");
//		System.out.print(l1);
		
		
		//userDetailrepo.save(user_detail);
		//System.out.print(UserDetail)
     //	System.out.print(l1.getUserName());
		return "Request completed........";
		
		
	}
	
	
//	@PostMapping("/check")
//	public String CheckValue( @ModelAttribute AdminDetail  user,Model m1 )
//     {
//	    System.out.println("helllo");
//	    System.out.println(user.getUserName());
//	    System.out.println(user.getPass());
//	    System.out.println(user);
//		System.out.println("check api is hit");
//		return "ans";
//	}
	

}
