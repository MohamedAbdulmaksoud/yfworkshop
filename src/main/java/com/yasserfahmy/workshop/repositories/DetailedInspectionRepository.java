package com.yasserfahmy.workshop.repositories;

import com.yasserfahmy.workshop.entities.DetailedInspection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailedInspectionRepository extends JpaRepository<DetailedInspection, Integer> {
}