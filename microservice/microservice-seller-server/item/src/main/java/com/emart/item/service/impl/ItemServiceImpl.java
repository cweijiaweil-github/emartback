package com.emart.item.service.impl;

import java.util.List;
import java.util.Map;

import com.emart.item.dao.ItemDao;
import com.emart.item.entity.Item;
import com.emart.item.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemDao itemDao;

    @Override
    public Item saveItem(Item item) {
        try {
            return this.itemDao.save(item);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Map<String,Object>> findItemList(String sellerId) {
        return this.itemDao.findItemList(sellerId);
    }

    @Override
    public int deleteItems(String item_id) {
        return this.itemDao.deleteByItemId(item_id);
    }

    @Override
    public void updateItemStock(Item item) {
        this.itemDao.save(item);
    }

    @Override
    public List<Map<String,Object>> findAllByItemName(String item_name) {
        return this.itemDao.findAllByItemName(item_name);
    }

    @Override
    public List<Map<String,Object>> findByPrices(Double priceStart,Double priceEnd) {
        return this.itemDao.findByPriceBetween(priceStart,priceEnd);
    }
    
    @Override
    public Item findAllByItemId(String item_id) {
        return this.itemDao.findByItemId(item_id);
    }
}