package com.example.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findById(long id);
	
	
}
