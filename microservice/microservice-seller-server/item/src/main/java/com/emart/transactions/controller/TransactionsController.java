package com.emart.transactions.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.emart.transactions.entity.Transactions;
import com.emart.transactions.service.TransactionsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "transactions")
public class TransactionsController {
        
    @Autowired
    TransactionsService transactionsService;

    @PostMapping(value = "/save")
    public Transactions saveTransactions(@RequestBody Transactions transactions) {
        return this.transactionsService.saveTransactions(transactions);
    }

    @GetMapping(value = "/list/{seller_id}")
    public Map<String,List<Transactions>> findAllTransactions(@PathVariable("seller_id") String seller_id) {
        Map<String,List<Transactions>> map = new HashMap<>();
        List<Transactions> list = this.transactionsService.findAllTransactions(seller_id);
        map.put("key", list);
        return map;
    }

}