package com.emart.order.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.emart.order.entity.Item;
import com.emart.order.entity.SubCategory;
import com.emart.order.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
// @Slf4j
@RequestMapping(value = "order")
public class OrderController {

    
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/searchItems/{item_name}")
    public Map<String,List<Map<String,Object>>> searchItems(@PathVariable("item_name") String item_name) {
        List<Map<String,Object>> item = this.orderService.searchItems(item_name);
        Map<String,List<Map<String,Object>>> map = new HashMap<>();
        map.put("key", item);
        return map;
    }
    
    @GetMapping(value = "/searchSubCategory/{sub_category_id}")
    public Map<String,List<Map<String,Object>>> findSubCategoryList(@PathVariable("sub_category_id") String sub_category_id) {
        List<Map<String,Object>> item = this.orderService.findSubCategoryList(sub_category_id);
        Map<String,List<Map<String,Object>>> map = new HashMap<>();
        map.put("key", item);
        return map;
    }
    
    @GetMapping(value = "/fillerItems/{priceStart}/{priceEnd}")
    public Map<String,List<Map<String,Object>>> fillerItems(@PathVariable("priceStart") Double priceStart,@PathVariable("priceEnd") Double priceEnd) {
        List<Map<String,Object>> item = this.orderService.fillerItems(priceStart,priceEnd);
        Map<String,List<Map<String,Object>>> map = new HashMap<>();
        map.put("key", item);
        return map;
    }

}