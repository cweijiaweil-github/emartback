package com.emart.subCategory.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.emart.category.service.CategoryService;
import com.emart.subCategory.entity.SubCategory;
import com.emart.subCategory.service.SubCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "subCategory")
public class SubCategoryController {
        
    @Autowired
    SubCategoryService subCategoryService;
    
    @Autowired
    CategoryService categoryService;

    @PostMapping(value = "/save")
    public SubCategory saveSubCategory(@RequestBody SubCategory subCategory) {
        return this.subCategoryService.saveSubCategory(subCategory);
    }


    @GetMapping(value = "/findsubcategorys/{sellerId}/{categoryId}")
    public Map<String, List<SubCategory>> findAllCategory(@PathVariable("sellerId") String sellerId,@PathVariable("categoryId") String categoryId) {
        List<SubCategory> subCategoryList = this.subCategoryService.findByCategory_id(sellerId,categoryId);
        Map<String, List<SubCategory>> map = new HashMap<>();
        if (subCategoryList.size() > 0) {
            map.put("key", subCategoryList);
        }
        return map;
    }
    
    @GetMapping(value = "/subcategorylist/{sub_category_id}")
    public List<Map<String,Object>> findSubCategoryList(@PathVariable("sub_category_id") String sub_category_id) {
        List<Map<String,Object>> subCategoryList = this.subCategoryService.findSubCategoryList(sub_category_id);
        return subCategoryList;
    }

}