package com.example.company.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "ProjectQuoteProfile")
@Table(name = "project_quote_profile")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProjectQuoteProfile {

  @Id
  @SequenceGenerator(name = "project_quote_profile_sequence", sequenceName = "project_quote_profile_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_quote_profile_sequence")
  private Long id;

  @Column(name = "name", nullable = false, updatable = false, columnDefinition = "TEXT")
  private String name;

  @Column(name = "email", nullable = false, updatable = false, columnDefinition = "TEXT")
  @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid Value For The Email Address")
  private String email;

  @Column(name = "phone_number", nullable = false, columnDefinition = "VARCHAR(20)")
  @Pattern(regexp = "^\\+?[0-9. ()-]{7,20}$", message = "Invalid Value For The Phone Number")
  private String phoneNumber;

  @Column(name = "company_name", nullable = false, columnDefinition = "TEXT")
  private String companyName;

  @Column(name = "company_service", nullable = false, columnDefinition = "TEXT")
  private String companyService;

  @Column(name = "company_budget", nullable = false, columnDefinition = "TEXT")
  private String companyBudget;
}
