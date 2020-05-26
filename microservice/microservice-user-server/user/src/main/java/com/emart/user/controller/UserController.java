package com.emart.user.controller;

import java.util.HashMap;
import java.util.Map;

import com.emart.user.entity.Buyer;
import com.emart.user.entity.Seller;
import com.emart.user.entity.User;
import com.emart.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/buyer/signup")
    public Buyer saveBuyer(@RequestBody Buyer buyer) {
        return this.userService.saveBuyer(buyer);
    }

    @PostMapping(value = "/seller/signup")
    public Seller saveBuyer(@RequestBody Seller seller) {
        return this.userService.saveSeller(seller);
    }

    @PostMapping(value = "/logout")
    public JSONObject saveBuyer(@RequestBody JSONObject userJson) {
        String email = userJson.getString("email");
        User user = userService.userLogout(email);
        JSONObject retJson = new JSONObject();
        if(user == null){
            retJson.put("data", "");
        } else{
            retJson.put("loginStatus",user.getLoginStatus());
        }
        return retJson;
    }

    @PostMapping(value = "/login")
    public Map<String,String>  findBuyer(@RequestBody User user) {
        int buyerCount = this.userService.findBuyer(user.getEmail(),user.getPassword());        
        Map<String,String> map = new HashMap<>();
        if  (buyerCount > 0){
            map.put("key", "buyer"+","+user.getEmail()+","+"/home/buyer");
            return map;
        }
        int sellerCount = this.userService.findSeller(user.getEmail(),user.getPassword());
        if  (sellerCount > 0){
            map.put("key", "seller"+","+user.getEmail()+","+"/home/seller");
              return map;
        }
        map.put("key", "/error");
        return map;
    }

}