package com.omkar.productmanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omkar.productmanagement.dto.ProductDto;
import com.omkar.productmanagement.dto.ResponseDto;
import com.omkar.productmanagement.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
    
    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @GetMapping("/product")
    public ResponseDto getAllProducts(){
        List<ProductDto> productDtos=productService.getAllProducts();
        return new ResponseDto(200, "Succcess", productDtos);
    }
    @GetMapping("/product/{productId}")
    public ResponseDto getProductByBId(@PathVariable long  productId){
        ProductDto productDto = productService.getProductById(productId);
        return new ResponseDto(200, "Succcess", productDto);
    }
    @DeleteMapping("/product/{productId}")
    public ResponseDto deleteProductById(@PathVariable long productId){
        productService.deleteById(productId);
        return new ResponseDto(200, "Success", "Delete Successfull");
    }
    @PostMapping("/product")
    public ResponseDto addProduct(@RequestBody ProductDto productDto){
        productService.addProduct(productDto);
        return new ResponseDto(200, "Success", "Add Successfull");
    }
}
