package com.emart.subCategory.service;

import java.util.List;

import com.emart.subCategory.entity.SubCategory;

import org.springframework.stereotype.Service;

@Service
public interface SubCategoryService {
        
    public SubCategory saveSubCategory(SubCategory subCategory);

    public List<SubCategory> findByCategory_id(String category_id);
    
    public List<SubCategory> findSubCategoryList(String subCateory_id);

    
}