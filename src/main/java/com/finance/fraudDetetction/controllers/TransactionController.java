package com.finance.fraudDetetction.controllers;

import com.finance.fraudDetetction.model.Transaction;
import com.finance.fraudDetetction.services.FraudDetectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private FraudDetectionService fraudDetectionService;
    public TransactionController(FraudDetectionService fraudDetectionService){
        this.fraudDetectionService=fraudDetectionService;
    }
    @GetMapping

    public List<Transaction> getAll(){

       return fraudDetectionService.getAllTransactions();
    }

    @GetMapping("/{id}")

    public Transaction getById(@PathVariable int id){//pah variable
        return fraudDetectionService.getTransactionbyId(id);
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction){
       return fraudDetectionService.processTransaction(transaction);
    }





}



//controller- exposing endpoints