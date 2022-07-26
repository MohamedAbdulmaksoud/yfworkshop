package com.yasserfahmy.workshop.repositories;

import com.yasserfahmy.workshop.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByName(String name);
    Customer findByCustomerCode(String customerCode);

}