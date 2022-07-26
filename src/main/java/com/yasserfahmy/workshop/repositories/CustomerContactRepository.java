package com.yasserfahmy.workshop.repositories;

import com.yasserfahmy.workshop.entities.CustomerContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerContactRepository extends JpaRepository<CustomerContact, Integer> {
}