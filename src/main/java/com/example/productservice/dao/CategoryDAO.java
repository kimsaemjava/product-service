package com.example.productservice.dao;

import com.example.productservice.entity.Category;

import java.util.List;

public interface CategoryDAO {
    void write(Category category);
    Category findByCategoryId(Long categoryId);
    List<Category> getCategory();
}
