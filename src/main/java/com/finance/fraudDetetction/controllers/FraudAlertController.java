package com.finance.fraudDetetction.controllers;

import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/fraud-alerts")
public class FraudAlertController {
    @GetMapping()
    public String getAll(){
        return "Fraud ho rha h nikal jao";
    }
    @GetMapping("/open")
    public String getOpenAlerts(){
        return "getting alert";

    }

    @PutMapping("/{id}")
    public String updateStatus(@PathVariable int id){
        return "id is: "+id;
    }

}
