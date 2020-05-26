package com.emart.fallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.emart.feign.ItemFeignClient;
import com.emart.order.entity.Item;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class ItemServiceFallback implements ItemFeignClient{
    
    @Override
    public List<Map<String,Object>> searchItems(@PathVariable("item_name") String item_name){
        Item item = new Item();
        List<Map<String,Object>> list = new ArrayList<>();
        item.setItem_name("Error querying product information!");
        Map<String,Object> map = new HashMap<>();
        map.put("key", item);
        list.add(map);
        
        return list;
    }
}