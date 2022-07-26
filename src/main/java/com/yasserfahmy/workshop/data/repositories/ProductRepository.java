package com.yasserfahmy.workshop.data.repositories;

import com.yasserfahmy.workshop.data.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}