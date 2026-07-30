package com.finance.fraudDetetction.controllers;

import com.finance.fraudDetetction.model.Customer;
import com.finance.fraudDetetction.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private CustomerService customerService;
    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }


    @GetMapping
    public List<Customer> getAll(){
        return customerService.getAllCustomers();
    }
    @GetMapping("/{id}")
    public  Customer getById(@PathVariable int id){
        return  customerService.getCustomerById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteById(int id){
        customerService.deleteCustomerById(id);
    }
    @PostMapping
    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }

}
