package com.emart.cart.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.emart.cart.entity.Cart;
import com.emart.cart.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
// @Slf4j
@RequestMapping(value = "cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping(value = "/addcart")
    public Cart addCartItems(@RequestBody Cart cart) {
        return this.cartService.addCarts(cart);
    }

    @GetMapping(value = "/getcart/{item_id}")
    public Cart getCartByItemId(@PathVariable("item_id") String item_id) {
        return this.cartService.getCartByItemId(item_id);
    }

    @GetMapping(value = "/listcarts")
    public Map<String, List<Cart>> listCarts() {
        List<Cart> cartlist = this.cartService.listCarts();
        Map<String, List<Cart>> map = new HashMap<>();
        if (cartlist.size() > 0) {
            map.put("key", cartlist);
        }
        return map;
    }

    @GetMapping(value = "/deletecart/{id}")
    public Map<String, List<Cart>> deleteCartItems(@PathVariable("id")  String id) {
        String[] idList = id.split(",");
        List<Long> LString = new ArrayList<Long>();
        for(String str : idList){
            LString.add(new Long(str));
        }
        cartService.deleteBatch(LString);
        return this.listCarts();
    }
   

}