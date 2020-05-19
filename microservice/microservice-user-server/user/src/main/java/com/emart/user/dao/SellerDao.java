package com.emart.user.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.emart.user.entity.Seller;

@Repository
public interface SellerDao  extends CrudRepository<Seller, Integer>{
    
    
}