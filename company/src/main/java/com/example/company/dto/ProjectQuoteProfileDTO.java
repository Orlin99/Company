package com.example.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectQuoteProfileDTO {
  private String name;
  private String email;
  private String phoneNumber;
  private String companyName;
  private String companyService;
  private String companyBudget;
}
