package com.yasserfahmy.workshop.data.repositories;

import com.yasserfahmy.workshop.data.entities.VisualInspection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisualInspectionRepository extends JpaRepository<VisualInspection, Integer> {
}