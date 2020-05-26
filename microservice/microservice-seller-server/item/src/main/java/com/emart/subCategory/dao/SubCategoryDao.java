package com.emart.subCategory.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import com.emart.subCategory.entity.SubCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface SubCategoryDao extends JpaRepository<SubCategory, String> {

List<SubCategory> findBySellerIdAndCategoryId(String sellerId,String categoryId);

@Query(value = "select s.*,i.price,i.item_id,i.item_name from t_sub_category as s,t_item as i where s.sub_category_id = i.subcategory_id and s.sub_category_id  =?1", nativeQuery = true)
List<Map<String,Object>> findBySubCategoryId(String subCateoryId);


}