package com.emart.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.user.dao.BuyerDao;
import com.emart.user.dao.SellerDao;
import com.emart.user.dao.UserDao;
import com.emart.user.entity.Buyer;
import com.emart.user.entity.Seller;
import com.emart.user.entity.User;
import com.emart.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    BuyerDao buyerDao;

    @Autowired
    SellerDao sellerDao;

    @Autowired
    UserDao userDao;

    @Override
    public Buyer saveBuyer(Buyer buyer) {
        try {
            return this.buyerDao.save(buyer);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Seller saveSeller(Seller seller) {
        try {
            return this.sellerDao.save(seller);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public int findBuyer(String mail, String password) {
        try {
            return this.userDao.findBuyer(mail, password);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int findSeller(String mail, String password) {
        try {
            return this.userDao.findSeller(mail, password);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public User userLogout(String email) {
        User user = userDao.findByEmail(email);
        if(user != null){
            user.setLoginStatus(Boolean.FALSE);
            user = userDao.save(user);
        }
        return user;
    }
}