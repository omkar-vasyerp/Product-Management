package com.omkar.productmanagement.service;

import java.util.List;

import com.omkar.productmanagement.dto.CategoryDto;


public interface CategoryService {

    List<CategoryDto> getAllCategory();
    CategoryDto getCategoryById(long categoryId);
    void addCategory(CategoryDto categoryDto);
    void deleteById(long categoryId);
}

