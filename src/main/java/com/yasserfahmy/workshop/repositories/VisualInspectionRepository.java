package com.yasserfahmy.workshop.repositories;

import com.yasserfahmy.workshop.entities.VisualInspection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisualInspectionRepository extends JpaRepository<VisualInspection, Integer> {
}