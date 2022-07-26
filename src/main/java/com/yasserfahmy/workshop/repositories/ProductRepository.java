package com.yasserfahmy.workshop.repositories;

import com.yasserfahmy.workshop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}