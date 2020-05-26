package com.emart.order.service;

import java.util.List;
import java.util.Map;

import com.emart.order.entity.Item;
import com.emart.order.entity.SubCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ItemService itemService;
    
    public List<Map<String,Object>> searchItems(String item_name) {

        return this.itemService.searchItems(item_name);
    }

    public List<Map<String,Object>> findSubCategoryList(String sub_category_id) {
        return this.itemService.findSubCategoryList(sub_category_id);
    }

    public List<Map<String,Object>> fillerItems(Double priceStart,Double priceEnd) {

        return this.itemService.fillerItems(priceStart,priceEnd);
    }
}
