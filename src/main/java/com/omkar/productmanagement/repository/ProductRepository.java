package com.omkar.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omkar.productmanagement.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
