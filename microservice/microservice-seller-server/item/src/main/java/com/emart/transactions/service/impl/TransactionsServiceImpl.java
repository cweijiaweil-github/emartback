package com.emart.transactions.service.impl;

import java.util.List;

import com.emart.transactions.dao.TransactionsDao;
import com.emart.transactions.entity.Transactions;
import com.emart.transactions.service.TransactionsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionsServiceImpl implements TransactionsService {
    
    
    @Autowired
    TransactionsDao transactionsDao;
    
   
    @Override
    public Transactions saveTransactions(Transactions transactions) {
        try {
            return this.transactionsDao.save(transactions);
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public List<Transactions> findAllTransactions(String seller_id){
        try {
            return this.transactionsDao.findAllBySellerId(seller_id);
        } catch (Exception e) {
            return null;
        }
    }
}