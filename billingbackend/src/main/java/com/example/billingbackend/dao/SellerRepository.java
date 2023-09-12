package com.example.billingbackend.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.billingbackend.entities.Seller;

public interface SellerRepository extends CrudRepository< Seller,Integer> {

}
