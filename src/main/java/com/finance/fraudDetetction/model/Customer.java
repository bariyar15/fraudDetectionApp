package com.finance.fraudDetetction.model;

public class Customer {
    private int id;
    private String name;
    private  String accountNumber;
    private String registeredCountry;

    public Customer(int id, String name, String accountNumber, String registeredCountry) {
        this.id = id;
        this.name = name;
        this.accountNumber = accountNumber;
        this.registeredCountry = registeredCountry;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getRegisteredCountry() {
        return registeredCountry;
    }

    public void setRegisteredCountry(String registeredCountry) {
        this.registeredCountry = registeredCountry;
    }

    public void setName(String name) {
        this.name = name;
    }
}
