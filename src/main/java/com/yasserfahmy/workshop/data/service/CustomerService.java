package com.yasserfahmy.workshop.data.service;

import com.yasserfahmy.workshop.data.entities.Customer;
import com.yasserfahmy.workshop.data.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    public List<Customer> finaAllCustomers(String stringFilter){
        if (stringFilter == null || stringFilter.isEmpty()) {
            return customerRepository.findAll();
        } else {
            return customerRepository.search(stringFilter);
        }
    }

    public long countCustomers(){
        return customerRepository.count();
    }
    public void deleteCustomer(Customer customer){
        customerRepository.delete(customer);
    }
    public void saveCustomer(Customer customer){
        if(customer == null){
            System.err.println("Contact is null. Save customer terminated.");
            return;
        }
        customerRepository.save(customer);
    }
}
