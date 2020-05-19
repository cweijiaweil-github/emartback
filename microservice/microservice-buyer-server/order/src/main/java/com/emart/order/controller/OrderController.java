package com.emart.order.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.emart.order.entity.Item;
import com.emart.order.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
// @Slf4j
@RequestMapping(value = "order")
public class OrderController {

    
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/search/{item_name}")
    public Map<String,List<Item>> searchItems(@PathVariable("item_name") String item_name) {
        List<Item> item = this.orderService.searchItems(item_name);
        Map<String,List<Item>> map = new HashMap<>();
        map.put("key", item);
        return map;
    }
    
    @GetMapping(value = "/fillerItems/{priceStart}/{priceEnd}")
    public Map<String,List<Item>> fillerItems(@PathVariable("priceStart") Double priceStart,@PathVariable("priceEnd") Double priceEnd) {
        List<Item> item = this.orderService.fillerItems(priceStart,priceEnd);
        Map<String,List<Item>> map = new HashMap<>();
        map.put("key", item);
        return map;
    }

}