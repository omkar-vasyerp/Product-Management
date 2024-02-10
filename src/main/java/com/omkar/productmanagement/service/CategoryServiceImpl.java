package com.omkar.productmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.omkar.productmanagement.dto.CategoryDto;
import com.omkar.productmanagement.exception.CategoryNotFoundException;
import com.omkar.productmanagement.model.Category;
import com.omkar.productmanagement.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository  categoryRepository;
    public CategoryServiceImpl(CategoryRepository  categoryRepository){
        this.categoryRepository=categoryRepository;
    }
    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categories=categoryRepository.findAll(); 
        List<CategoryDto> categoryDtos=new ArrayList<>();
        for (Category category : categories) {
            CategoryDto categoryDto =new CategoryDto();
            categoryDto.setCategoryId(category.getCategoryId());
            categoryDto.setCategoryName(category.getCategoryName());
            categoryDtos.add(categoryDto);
        }
        return categoryDtos;
    }

    @Override
    public CategoryDto getCategoryById(long categoryId) {
      Category category = categoryRepository.findById(categoryId).orElseThrow(()->new CategoryNotFoundException("Category Not Found With Id:" +categoryId));
      CategoryDto categoryDto =new CategoryDto();
            categoryDto.setCategoryId(category.getCategoryId());
            categoryDto.setCategoryName(category.getCategoryName());
          return categoryDto;
    }

    @Override
    public void addCategory(CategoryDto categoryDto) {
       Category category=new Category();
    //    category.setCategoryId(categoryDto.getCategoryId());
       category.setCategoryName(categoryDto.getCategoryName());
       categoryRepository.save(category);
    }

    @Override
    public void deleteById(long categoryId) {
      if (!categoryRepository.existsById(categoryId)) {
        throw new CategoryNotFoundException("Category Not Found With Id: "+categoryId);
      }
      categoryRepository.deleteById(categoryId);
    }

}
