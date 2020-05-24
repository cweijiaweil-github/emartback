package com.emart.item.service;

import java.util.List;
import java.util.Map;

import com.emart.item.entity.Item;

import org.springframework.stereotype.Service;

@Service
public interface ItemService {
	
    public Item saveItem(Item item);

    public List<Map<String,Object>> findItemList(String sellerId);

    public int deleteItems(String item_id);

    public void updateItemStock(Item item);

    public List<Item> findAllByItemName(String item_name);
    
    public List<Item> findByPrices(Double priceStart,Double priceEnd);

    public Item findAllByItemId(String item_id);

}