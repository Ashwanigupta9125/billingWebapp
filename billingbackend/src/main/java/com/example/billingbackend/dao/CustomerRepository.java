package com.example.billingbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.billingbackend.entities.Customer;



@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query(value ="select * from Customer where customer_name =:name",nativeQuery = true)
	public Customer findbycustomer_name(@Param("name") String name);

	
	
}
