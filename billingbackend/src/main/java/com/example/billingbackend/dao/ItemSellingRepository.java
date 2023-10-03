package com.example.billingbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.billingbackend.entities.ItemSelling;

@Repository
public interface ItemSellingRepository extends JpaRepository<ItemSelling, Integer>{

}
