package com.emart.order.service;

import java.util.List;

import com.emart.order.entity.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ItemService itemService;
    
    public List<Item> searchItems(String item_name) {

        return this.itemService.searchItems(item_name);
    }

    public List<Item> fillerItems(Double priceStart,Double priceEnd) {

        return this.itemService.fillerItems(priceStart,priceEnd);
    }
}
