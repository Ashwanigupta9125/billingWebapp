package com.example.billingbackend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.billingbackend.dao.BillDetailBuyRepo;
import com.example.billingbackend.dao.ProductsRepository;
import com.example.billingbackend.dao.SellerRepository;
import com.example.billingbackend.entities.BillDetailBuy;
import com.example.billingbackend.entities.Products;
import com.example.billingbackend.exception.ResourceNotFoundException;

import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {


	
	@Autowired
	private BillDetailBuyRepo billDetailBuyRepo;
	
	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	
	
	public void CheckProductId(int product_id) {
		productsRepository.findById(product_id).orElseThrow(() -> new ResourceNotFoundException("Product", "Product id ", product_id));
	}
	
	
	
	@Transactional
	public void CurrentStockUpdate(int id,double current_quentity) {
		//add condition during frontend making if value get 0 or less give some warning
		
		CheckProductId(id);
		double PresntStock=productsRepository.findById(id).get().getAvailable_stock();
//		System.out.println(PresntStock);
		
		double total_quatity=PresntStock+current_quentity;
		
		
		int TotalUpdate=productsRepository.UpdateStock(total_quatity,id);
//		System.out.println(TotalUpdate);
//	
//		System.out.println(total_quatity+"       "+PresntStock);
		
		
	}
	
	public BillDetailBuy getBillInvoiceNo(int seller_id) {
		sellerRepository.findById(seller_id)
		.orElseThrow(() -> new ResourceNotFoundException("Seller", "Seller id ", seller_id));
		System.out.println("check bill i obj");
		
		return  billDetailBuyRepo.save(new BillDetailBuy(seller_id));
	}
	
	

}
