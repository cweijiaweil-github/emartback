package com.emart.category.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.emart.category.entity.Category;
import com.emart.category.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "category")
public class CategoryController {
        
    @Autowired
    CategoryService categoryService;

    @PostMapping(value = "/save")
    public Category saveBuyer(@RequestBody Category category) {
        return this.categoryService.saveCategory(category);
    }

    @GetMapping(value = "/findcategorys/{sellerId}")
    public Map<String, List<Category>> findAllCategory(@PathVariable("sellerId") String sellerId) {
        List<Category> categoryList = this.categoryService.findAllCategory(sellerId);
        Map<String, List<Category>> map = new HashMap<>();
        if (categoryList.size() > 0) {
            map.put("key", categoryList);
        }
        return map;
    }
}