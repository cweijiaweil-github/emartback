package com.emart.user.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.emart.user.entity.Buyer;

@Repository
public interface BuyerDao  extends CrudRepository<Buyer, Integer>{
    
}