package com.emart.transactions.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

import com.emart.transactions.entity.Transactions;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TransactionsDao  extends JpaRepository<Transactions, Integer>{

    public List<Transactions> findAllBySellerId(String seller);

}