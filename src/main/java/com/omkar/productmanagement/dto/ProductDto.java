package com.omkar.productmanagement.dto;

import com.omkar.productmanagement.model.Category;

import lombok.Data;

@Data
public class ProductDto {
    private long productId;

    private String productName;

    private long productPrice;

    private String productDesc; 

    private Category category;
}
