package com.emart.subCategory.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

import com.emart.subCategory.entity.SubCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface SubCategoryDao extends JpaRepository<SubCategory, String> {

List<SubCategory> findByCategoryId(String categoryId);

@Query(value = "select * from t_sub_category as t where t.sub_category_id = ?1", nativeQuery = true)
public List<String> findSubCategoryList(String subCateory_id);


}