package com.emart.order.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.emart.feign.ItemFeignClient;
import com.emart.order.entity.Item;
import com.emart.order.entity.SubCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ItemService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ItemFeignClient itemFeignClient;

    public List<Map<String,Object>> searchItems(String item_name) {
        // String itemUrl = "http://APP-SELLER/item/searchItems/{item_name}";
        // Item[] model =  this.restTemplate.getForObject(itemUrl, Item[].class, item_name);
        // return Arrays.asList(model);
        List<Map<String,Object>> listItem =  this.itemFeignClient.searchItems(item_name);
        return listItem;
    }

    public List<Map<String,Object>> fillerItems(Double priceStart, Double priceEnd) {
        String itemUrl = "http://APP-SELLER/item/fillerItems/{priceStart}/{priceEnd}";
        List<Map<String,Object>> model = this.restTemplate.getForObject(itemUrl, List.class, priceStart, priceEnd);
        return model;
    }
    public List<Map<String,Object>> findSubCategoryList(String sub_category_id) {
        String itemUrl = "http://APP-SELLER/subCategory/subcategorylist/{sub_category_id}";
        List<Map<String,Object>> model = this.restTemplate.getForObject(itemUrl, List.class, sub_category_id);
        return model;
    }

    public Item getItemByItemId(String item_id) {
        String itemUrl = "http://APP-SELLER/item/getItemByItemId/{item_id}";
        return this.restTemplate.getForObject(itemUrl, Item.class, item_id);
    }

}