package com.example.billingbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.billingbackend.entities.ItemBought;

@Repository
public interface ItemBoughtRepostory extends JpaRepository< ItemBought,Integer>{
	

}
