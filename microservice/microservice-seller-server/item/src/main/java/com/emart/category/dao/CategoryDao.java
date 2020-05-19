package com.emart.category.dao;

import org.springframework.stereotype.Repository;

import com.emart.category.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoryDao  extends JpaRepository<Category, Integer>{
    
    
}