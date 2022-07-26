package com.yasserfahmy.workshop.data.repositories;

import com.yasserfahmy.workshop.data.entities.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository extends JpaRepository<Inquiry, Integer> {
}