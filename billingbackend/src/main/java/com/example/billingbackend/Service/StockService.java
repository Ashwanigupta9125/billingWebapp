package com.example.billingbackend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.billingbackend.dao.ProductsRepository;

@Service
public class StockService {

	@Autowired
	private ProductsRepository productsRepository;
	
	
	public void CurrentStockUpdate(int id,double current_quentity) {
	
		
		double total_quatity=productsRepository.findById(id).get().getAvailable_stock()+current_quentity;
		//add condition during frontend making if value get 0 or less give some warning
		System.out.print(total_quatity);
		productsRepository.UpdateStock(total_quatity,id);

	}
	
}
