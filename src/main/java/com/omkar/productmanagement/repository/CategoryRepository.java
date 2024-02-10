package com.omkar.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omkar.productmanagement.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    
} 
