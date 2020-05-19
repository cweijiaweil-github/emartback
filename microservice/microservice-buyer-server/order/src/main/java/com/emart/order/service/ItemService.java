package com.emart.order.service;

import java.util.Arrays;
import java.util.List;

import com.emart.feign.ItemFeignClient;
import com.emart.order.entity.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ItemService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ItemFeignClient itemFeignClient;

    public List<Item> searchItems(String item_name) {
        // String itemUrl = "http://APP-SELLER/item/searchItems/{item_name}";
        // Item[] model =  this.restTemplate.getForObject(itemUrl, Item[].class, item_name);
        // return Arrays.asList(model);
        List<Item> listItem =  this.itemFeignClient.searchItems(item_name);
        return listItem;
    }

    public List<Item> fillerItems(Double priceStart, Double priceEnd) {
        String itemUrl = "http://APP-SELLER/item/fillerItems/{priceStart}/{priceEnd}";
        Item[] model = this.restTemplate.getForObject(itemUrl, Item[].class, priceStart, priceEnd);
        return Arrays.asList(model);
    }

    public Item getItemByItemId(String item_id) {
        String itemUrl = "http://APP-SELLER/item/getItemByItemId/{item_id}";
        return this.restTemplate.getForObject(itemUrl, Item.class, item_id);
    }

}