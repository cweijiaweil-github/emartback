package com.emart.user.service;

import com.emart.user.entity.Buyer;
import com.emart.user.entity.Seller;
import com.emart.user.entity.User;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    
    public Buyer saveBuyer(Buyer buyer);

    public Seller saveSeller(Seller seller);
    
    public int findBuyer(String mail,String password);
    
    public int findSeller(String mail,String password);

    public User userLogout(String email);
}