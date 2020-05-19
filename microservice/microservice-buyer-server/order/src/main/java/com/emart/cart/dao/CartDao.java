package com.emart.cart.dao;

import java.util.List;

import com.emart.cart.entity.Cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer>{

    @Modifying
    @Transactional
    @Query(value="delete from t_cart t where t.id in (?1)",nativeQuery=true)
    public void deleteBatch(List<Long> ids);
    // public void deleteCartByIdIn(List<Integer> ids);
    
}