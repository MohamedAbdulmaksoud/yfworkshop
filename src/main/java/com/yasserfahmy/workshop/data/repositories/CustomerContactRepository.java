package com.yasserfahmy.workshop.data.repositories;

import com.yasserfahmy.workshop.data.entities.CustomerContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerContactRepository extends JpaRepository<CustomerContact, Integer> {
}