package com.omkar.productmanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private long productId;
    @Column(name="product_name")
    private String productName;
    @Column(name="product_price")
    private long productPrice;
    @Column(name="product_desc")
    private String productDesc; 

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
}
