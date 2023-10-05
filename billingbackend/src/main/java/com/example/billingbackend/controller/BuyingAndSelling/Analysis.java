package com.example.billingbackend.controller.BuyingAndSelling;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.billingbackend.dao.ItemBoughtRepostory;
import com.example.billingbackend.dao.ItemSellingRepository;
import com.example.billingbackend.entities.ItemBought;
import com.example.billingbackend.entities.ItemSelling;

@RestController
@RequestMapping("/analysis")
public class Analysis{
	
	@Autowired
	private ItemBoughtRepostory itemBoughtRepostory;
	@Autowired
	private ItemSellingRepository itemSellingRepository;
	
	@GetMapping("/buydetail/{dateStart}/{dateEnd}")
	public List<ItemBought> buyDetail(@PathVariable LocalDate dateStart,@PathVariable LocalDate dateEnd){
		List<ItemBought> allDateBoughts=itemBoughtRepostory.FindTransitionOfBuyBtw(dateStart, dateEnd);
		System.out.print("Hello ok all Done");
		return allDateBoughts;
	}
	
	@GetMapping("/buydetail/{dateStart}")
	public List<ItemBought> buyDetail(@PathVariable LocalDate dateStart){
		List<ItemBought> allDateBoughts=itemBoughtRepostory.FindTransitionOfBuy(dateStart);
		System.out.print("Hello running  ");
		return allDateBoughts;
	}
      
	
   ///////////////////////////////////////////////////////////////////     Selling detail    ///////////////////////////////////////////////////////////
	@GetMapping("/selldetail/{dateStart}/{dateEnd}")
	public List<ItemSelling> sellDetail(@PathVariable LocalDate dateStart,@PathVariable LocalDate dateEnd){
		List<ItemSelling> allsellDate=itemSellingRepository.FindTransitionOfBuyBtw(dateStart, dateEnd);
		System.out.print("Hello ok all Done");
		return allsellDate;
	}
	
	
	@GetMapping("/selldetail/{dateStart}")
	public List<ItemSelling> sellDetail(@PathVariable LocalDate dateStart){
		List<ItemSelling> allsellDate=itemSellingRepository.FindTransitionOfBuy(dateStart);
		return allsellDate;
	}
    

	
}
