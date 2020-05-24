package com.emart.category.service.impl;

import java.util.List;

import com.emart.category.dao.CategoryDao;
import com.emart.category.entity.Category;
import com.emart.category.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    
    
    @Autowired
    CategoryDao categoryDao;
    
   
    @Override
    public Category saveCategory(Category category) {
        try {
            return this.categoryDao.save(category);
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public List<Category> findAllCategory(String sellerId){
        try {
            return this.categoryDao.findAllBySellerId(sellerId);
        } catch (Exception e) {
            return null;
        }
    }
}