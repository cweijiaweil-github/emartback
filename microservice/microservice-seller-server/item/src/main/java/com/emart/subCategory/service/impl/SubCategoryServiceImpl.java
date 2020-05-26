package com.emart.subCategory.service.impl;

import java.util.List;
import java.util.Map;

import com.emart.subCategory.dao.SubCategoryDao;
import com.emart.subCategory.entity.SubCategory;
import com.emart.subCategory.service.SubCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    SubCategoryDao subCategoryDao;

    @Override
    public SubCategory saveSubCategory(SubCategory subCategory) {
        try {
            return this.subCategoryDao.save(subCategory);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<SubCategory> findByCategory_id(String sellerId,String categoryId) {
        try {
            return this.subCategoryDao.findBySellerIdAndCategoryId(sellerId,categoryId);
            
        } catch (Exception e) {
            return null;
        }
    }

    
    @Override
    public List<Map<String,Object>> findSubCategoryList(String subCateory_id) {
        try {
            return this.subCategoryDao.findBySubCategoryId(subCateory_id);
        } catch (Exception e) {
            return null;
        }
    }
}