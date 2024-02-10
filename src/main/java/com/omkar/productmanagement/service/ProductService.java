package com.omkar.productmanagement.service;

import java.util.List;

import com.omkar.productmanagement.dto.ProductDto;

public interface ProductService {
    
    List<ProductDto> getAllProducts();
    ProductDto getProductById(long productId);
    void addProduct(ProductDto productDto);
    void deleteById(long productId);
    
}
