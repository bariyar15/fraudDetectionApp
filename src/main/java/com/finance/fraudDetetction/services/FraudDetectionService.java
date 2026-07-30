package com.finance.fraudDetetction.services;

import com.finance.fraudDetetction.model.Customer;
import com.finance.fraudDetetction.model.Transaction;
import com.finance.fraudDetetction.repository.CustomerRepository;
import com.finance.fraudDetetction.repository.ITransactionRepository;
//import com.finance.fraudDetetction.repository.InMemoryTransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class FraudDetectionService {
    private ITransactionRepository transactionRepository;
    private CustomerRepository customerRepository;
    public FraudDetectionService(ITransactionRepository transactionRepository, CustomerRepository customerRepository){
        this.transactionRepository= transactionRepository;
        this.customerRepository= customerRepository;

    }

    public List<Transaction> getAllTransactions(){
        return  transactionRepository.findAll();
    }
    //get =TransactionById
    public Transaction getTransactionbyId(int id){
         return transactionRepository.findById(id);
    }

    public Transaction processTransaction(Transaction transaction){
       int newGeneratedIdTxn= transactionRepository.save(transaction);
       transaction.setId(newGeneratedIdTxn);
       int riskScore=0;

       List<String> reasons= new ArrayList<>();

       //Fraud Detection
        //Rule 1- high amount
        if(transaction.getAmount().compareTo(new BigDecimal(10000))>0){
            riskScore+=40;
            reasons.add("Hig transaction amount rs. "+ transaction.getAmount());

        }
        //rule 2- odd hrs

        int hour= transaction.getTxnTimeStamp().getHour();
        if(hour>=0 && hour<5){
            riskScore+=20;
            reasons.add("transaction made at odd hr "+ hour);
        }

        //rule 3- Location mismatch
        Customer customer= customerRepository.getCustomerById(transaction.getCustomerId());

        if(customer!=null && customer.getRegisteredCountry().equalsIgnoreCase(transaction.getTxnCountry())){
            riskScore+=30;
            reasons.add("Customer country mismatched!!-"+ transaction.getTxnCountry());
        }
        if(!reasons.isEmpty()){
            transactionRepository.updateStatus(transaction.getId(), "FLAGGED");
        }else{
            transactionRepository.updateStatus(transaction.getId(),"SUCCESS");
        }





       return transaction;


    }

}
