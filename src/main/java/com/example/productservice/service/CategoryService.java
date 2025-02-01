package com.example.productservice.service;

import com.example.productservice.dto.CategoryRequest;
import com.example.productservice.dto.CategoryResponse;
import com.example.productservice.entity.Category;

import java.util.List;

public interface CategoryService {
    void write(CategoryRequest category);
    List<CategoryResponse> getCategory();
    String getOrderData();
}
