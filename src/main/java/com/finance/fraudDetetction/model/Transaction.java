package com.finance.fraudDetetction.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private int id;
    private BigDecimal amount;
    private int customerId;
    private String txnCountry;
    private LocalDateTime txnTimeStamp;
    private  String status;

    public Transaction(int id, BigDecimal amount, String txnCountry,
                       LocalDateTime txnTimeStamp, String status, int customerId) {
        this.id = id;
        this.amount = amount;
        this.txnCountry = txnCountry;
        this.txnTimeStamp = txnTimeStamp;
        this.status = status;
        this.customerId= customerId;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTxnCountry() {
        return txnCountry;
    }

    public void setTxnCountry(String txnCountry) {
        this.txnCountry = txnCountry;
    }

    public LocalDateTime getTxnTimeStamp() {
        return txnTimeStamp;
    }

    public void setTxnTimeStamp(LocalDateTime txnTimeStamp) {
        this.txnTimeStamp = txnTimeStamp;
    }



    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
