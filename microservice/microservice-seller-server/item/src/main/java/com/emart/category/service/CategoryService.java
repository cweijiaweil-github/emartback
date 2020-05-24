package com.emart.category.service;

import java.util.List;

import com.emart.category.entity.Category;

import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
        
    public Category saveCategory(Category category);

    public List<Category> findAllCategory(String sellerId);
    
}