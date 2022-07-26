package com.yasserfahmy.workshop.data.repositories;

import com.yasserfahmy.workshop.data.entities.DetailedInspection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailedInspectionRepository extends JpaRepository<DetailedInspection, Integer> {
}