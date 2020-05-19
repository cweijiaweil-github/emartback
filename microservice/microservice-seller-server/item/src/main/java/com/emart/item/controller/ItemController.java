package com.emart.item.controller;

import com.emart.category.entity.Category;
import com.emart.category.service.CategoryService;
import com.emart.item.entity.Item;
import com.emart.item.service.ItemService;
import com.emart.subCategory.entity.SubCategory;
import com.emart.subCategory.service.SubCategoryService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @Autowired
    SubCategoryService subCategoryService;

    @Autowired
    CategoryService categoryService;

    @PostMapping(value = "/addItem")
    public Item addItems(@RequestBody Item item) {
        return this.itemService.saveItem(item);
    }
    
    @GetMapping(value = "/getItemByItemId/{item_id}")
    public Item getItemByItemId(@PathVariable("item_id") String item_id) {
        return this.itemService.findAllByItemId(item_id);
    }
    
    @GetMapping(value = "/searchItems/{item_name}")
    public List<Item> searchItems(@PathVariable("item_name") String item_name) {
        return this.itemService.findAllByItemName(item_name);
    }

    @GetMapping(value = "/fillerItems/{priceStart}/{priceEnd}")
    public List<Item> fillerItems(@PathVariable("priceStart") Double priceStart,@PathVariable("priceEnd") Double priceEnd) {
        return this.itemService.findByPrices(priceStart,priceEnd);
    }
    
    @GetMapping(value = "/deleteItem/{item_id}")
    public Map<String, List<Map<String,Object>>> deleteItems(@PathVariable("item_id") String item_id) {
        int flg = this.itemService.deleteItems(item_id);
        if(flg > 0){
            return this.viewStock();
        }else{
            return null;
        }
    }

    @PostMapping(value = "/updateItem")
    public Map<String, List<Map<String,Object>>> updateItemStock(@RequestBody Item item) {
        this.itemService.updateItemStock(item);
        return this.viewStock();
    }
    
    @GetMapping(value = "/listItems")
    public Map<String, List<Map<String,Object>>> viewStock() {
        List<Map<String,Object>> list = this.itemService.findItemList();
        Map<String, List<Map<String,Object>>> map = new HashMap<>();
        map.put("key", list);
        return map;
    }



}