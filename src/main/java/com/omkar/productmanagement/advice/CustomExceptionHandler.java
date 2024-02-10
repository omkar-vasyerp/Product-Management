package com.omkar.productmanagement.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.omkar.productmanagement.dto.ResponseDto;
import com.omkar.productmanagement.exception.CategoryNotFoundException;
import com.omkar.productmanagement.exception.ProductNotFoundException;

@RestControllerAdvice
public class CustomExceptionHandler {
    
    @ResponseStatus(code=HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public ResponseDto  productNotFoundExceptionHandling(ProductNotFoundException ex){
        return new ResponseDto(404, "Failure", ex.getMessage());
    }

    @ResponseStatus(code=HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public  ResponseDto categoryNotFoundExceptionHandlinng(CategoryNotFoundException ex){
        return new ResponseDto(404, "Failure", ex.getMessage());
    }
}
