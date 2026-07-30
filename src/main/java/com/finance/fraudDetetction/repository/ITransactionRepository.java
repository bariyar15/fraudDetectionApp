package com.finance.fraudDetetction.repository;

import com.finance.fraudDetetction.model.Transaction;

import java.util.List;

public interface ITransactionRepository {
    List<Transaction> findAll();

    Transaction findById(int id);

    int save(Transaction transaction);

    void updateStatus(int id, String status);
}
