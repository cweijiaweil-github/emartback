package com.emart.transactions.service;

import java.util.List;
import com.emart.transactions.entity.Transactions;

import org.springframework.stereotype.Service;

@Service
public interface TransactionsService {
        
    public Transactions saveTransactions(Transactions transactions);

    public List<Transactions> findAllTransactions(String seller_id);
    
}