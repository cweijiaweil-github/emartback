package com.emart.item.dao;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import com.emart.item.entity.Item;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ItemDao extends JpaRepository<Item, Integer>{

    @Query(value = "select i.item_name,c.category_name,s.sub_category_id from t_item as i,t_category as c,t_sub_category as s where i.category_id = c.category_id and i.category_id = s.category_id", nativeQuery = true)
    public List<Map<String,Object>> findItemList();
    
    @Modifying
    @Transactional
    @Query(value = "delete from t_item as t where t.item_id = ?1", nativeQuery = true)
    public int deleteByItemId(String itemId);

    @Query(value = "select * from t_item as t where t.item_name = ?1", nativeQuery = true)
    public List<Item> findAllByItemName(String item_name);

    public List<Item> findByPriceBetween(Double priceStart,Double priceEnd);

    public Item findByItemId(String itemId);

}