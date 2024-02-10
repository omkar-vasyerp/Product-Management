package com.omkar.productmanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omkar.productmanagement.dto.CategoryDto;
import com.omkar.productmanagement.dto.ResponseDto;
import com.omkar.productmanagement.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService= categoryService;
    }
    @GetMapping("/category")
    public ResponseDto getAllcategorys(){
        List<CategoryDto> categoryDtos=categoryService.getAllCategory();
        return new ResponseDto(200, "Succcess", categoryDtos);
    }
    @GetMapping("/category/{categoryId}")
    public ResponseDto getcategoryByBId(@PathVariable long  categoryId){
        CategoryDto categoryDto = categoryService.getCategoryById(categoryId);
        return new ResponseDto(200, "Succcess", categoryDto);
    }
    @DeleteMapping("/category/{categoryId}")
    public ResponseDto deletecategoryById(@PathVariable long categoryId){
        categoryService.deleteById(categoryId);
        return new ResponseDto(200, "Success", "Delete Successfull");
    }
    @PostMapping("/category")
    public ResponseDto addcategory(@RequestBody CategoryDto categoryDto){
        categoryService.addCategory(categoryDto);
        return new ResponseDto(200, "Success", "Add Successfull");
    }
}
