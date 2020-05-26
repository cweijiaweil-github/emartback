package com.emart.feign;

import java.util.List;
import java.util.Map;

import com.emart.fallback.ItemServiceFallback;
import com.emart.order.entity.Item;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "app-seller",fallback = ItemServiceFallback.class)
public interface ItemFeignClient {
    
    @GetMapping(value = "/item/searchItems/{item_name}")
    public List<Map<String,Object>> searchItems(@PathVariable("item_name") String item_name);
}