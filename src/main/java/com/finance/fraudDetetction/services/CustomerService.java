package com.finance.fraudDetetction.services;

import com.finance.fraudDetetction.model.Customer;
import com.finance.fraudDetetction.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }
    public List<Customer> getAllCustomers(){
        return customerRepository.getCustomers();
    }
    public Customer getCustomerById(int id){
        return customerRepository.getCustomerById(id);
    }
    public void deleteCustomerById(int id){
        customerRepository.deleteCustomerbyId(id);
    }

    public void  addCustomer(Customer customer){
        customerRepository.addCustomer(customer);
    }


}
