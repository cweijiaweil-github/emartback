package com.emart.cart.service;

import java.util.List;

import com.emart.cart.dao.CartDao;
import com.emart.cart.entity.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    CartDao cartDao;

    public Cart addCarts(Cart cart) {
        return this.cartDao.save(cart);
    }

    public List<Cart> listCarts() {
        return this.cartDao.findAll();
    }

    public void deleteBatch(List<Long> LString) {
        cartDao.deleteBatch(LString);
    }

}
