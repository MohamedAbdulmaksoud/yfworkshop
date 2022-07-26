package com.yasserfahmy.workshop.data.repositories;

import com.yasserfahmy.workshop.data.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByCustomerCodeContainsOrNameContainsAllIgnoreCase(String customerCode, String name);

    @Query("select c from Customer c " +
            "where lower(c.customerCode) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(c.name) like lower(concat('%', :searchTerm, '%'))")
    List<Customer> search(@Param("searchTerm") String searchTerm);
}