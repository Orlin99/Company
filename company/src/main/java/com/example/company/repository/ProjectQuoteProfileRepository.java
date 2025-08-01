package com.example.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.company.model.ProjectQuoteProfile;

@Repository
public interface ProjectQuoteProfileRepository extends JpaRepository<ProjectQuoteProfile, Long> {
  // Default Empty Implementation
}
