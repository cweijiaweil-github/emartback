package com.emart.purchaseHistory.controller;

import java.util.List;
import java.util.Map;

import com.emart.purchaseHistory.entity.PurchaseHistory;
import com.emart.purchaseHistory.service.PurchaseHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "history")
public class PurchaseHistoryController {

    @Autowired
    PurchaseHistoryService purchaseHistoryService;

    @PostMapping(value = "/checkout")
    public PurchaseHistory checkout(@RequestBody PurchaseHistory purchaseHistory) {
        return this.purchaseHistoryService.checkout(purchaseHistory);
    }

    @GetMapping(value = "/historyList/{buyer_id}")
    public Map<String,List<Map<String,Object>>> getHistoryList(@PathVariable("buyer_id") String buyer_id) {
        return this.purchaseHistoryService.getHistoryList(buyer_id);
    }
}