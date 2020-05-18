package com.emart.fallback;

import java.util.ArrayList;
import java.util.List;

import com.emart.feign.ItemFeignClient;
import com.emart.order.entity.Item;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class ItemServiceFallback implements ItemFeignClient{
    
    @Override
    public List<Item> searchItems(@PathVariable("item_name") String item_name){
        Item item = new Item();
        List<Item> list = new ArrayList<>();
        item.setItem_name("Error querying product information!");
        list.add(item);
        return list;
    }
}