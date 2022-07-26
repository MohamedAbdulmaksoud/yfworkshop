package com.yasserfahmy.workshop.repositories;

import com.yasserfahmy.workshop.entities.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository extends JpaRepository<Inquiry, Integer> {
}