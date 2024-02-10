package com.omkar.productmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.omkar.productmanagement.dto.ProductDto;
import com.omkar.productmanagement.exception.ProductNotFoundException;
import com.omkar.productmanagement.model.Product;
import com.omkar.productmanagement.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository= productRepository;
    }
    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos= new ArrayList<>();
        for (Product product : products) {
            ProductDto productDto = new ProductDto();
            productDto.setProductId(product.getProductId());
            productDto.setProductName(product.getProductName());
            productDto.setProductPrice(product.getProductPrice());
            productDto.setProductDesc(product.getProductDesc());
            productDto.setCategory(product.getCategory());
            productDtos.add(productDto);
        }
        return productDtos;
        
    }

    @Override
    public ProductDto getProductById(long productId) {
     Product product=productRepository.findById(productId).orElseThrow(()->new ProductNotFoundException("Product Not Found With Id: "+productId));
     ProductDto productDto = new ProductDto();
     productDto.setProductId(product.getProductId());
     productDto.setProductName(product.getProductName());
     productDto.setProductPrice(product.getProductPrice());
     productDto.setProductDesc(product.getProductDesc());
     productDto.setCategory(product.getCategory());
       return productDto;
    }

    @Override
    public void addProduct(ProductDto productDto) {
        
        Product product = new Product();
        product.setProductName(productDto.getProductName());
        product.setProductPrice(productDto.getProductPrice());
        product.setProductDesc(productDto.getProductDesc());
        productRepository.save(product);
        
    }

    @Override
    public void deleteById(long productId) {
        if(!productRepository.existsById(productId)){
            throw new ProductNotFoundException("Product Not Found With Id: "+productId);
        }
        productRepository.deleteById(productId);
    }
}
