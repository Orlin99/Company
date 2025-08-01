package com.example.company.utility;

import java.util.List;
import java.util.regex.Pattern;

import com.example.company.dto.ProjectQuoteProfileDTO;
import com.example.company.exception.InvalidCompanyBudgetException;
import com.example.company.exception.InvalidCompanyNameException;
import com.example.company.exception.InvalidCompanyServiceException;
import com.example.company.exception.InvalidEmailException;
import com.example.company.exception.InvalidNameException;
import com.example.company.exception.InvalidPhoneNumberException;
import com.example.company.model.ProjectQuoteProfile;

public final class ProjectQuoteProfileUtility {

  private ProjectQuoteProfileUtility() {
    // Default Empty Constructor
  }

  public static final String SUCCESSFULLY_CREATED_PROJECT_QUOTE_RESPONSE = "The Project Quote Was Created Successfully";

  @SuppressWarnings({ "java:S5998", "java:S6353" })
  private static final String NAME_REGEX = "^([A-Z][a-zA-Z-]*\\s){1,}[A-Z][a-zA-Z-]*$";
  private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
  private static final String PHONE_NUMBER_REGEX = "^\\+?[0-9. ()-]{7,20}$";
  private static final String COMPANY_NAME_REGEX = "^[A-Z][a-zA-Z0-9 ]{2,}$";
  private static final String COMPANY_SERVICE_REGEX = "^[A-Z][a-zA-Z\\s-]*$";

  private static final String FIRST_BUDGET_OPTION = "$5.000 - $10.000";
  private static final String SECOND_BUDGET_OPTION = "$10.000 - $20.000";
  private static final String THIRD_BUDGET_OPTION = "$20.000 - $50.000";
  private static final String FOURTH_BUDGET_OPTION = "$50.000 +";

  private static final Pattern NAME_PATTERN = Pattern.compile(NAME_REGEX);
  private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
  private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile(PHONE_NUMBER_REGEX);
  private static final Pattern COMPANY_NAME_PATTERN = Pattern.compile(COMPANY_NAME_REGEX);
  private static final Pattern COMPANY_SERVICE_PATTERN = Pattern.compile(COMPANY_SERVICE_REGEX);
  private static final List<String> BUDGET_OPTIONS = List.of(FIRST_BUDGET_OPTION, SECOND_BUDGET_OPTION, THIRD_BUDGET_OPTION, FOURTH_BUDGET_OPTION);

  private static final String ERROR_MESSAGE_FOR_INVALID_NAME = "Invalid name format: ";
  private static final String ERROR_MESSAGE_FOR_INVALID_EMAIL = "Invalid email format: ";
  private static final String ERROR_MESSAGE_FOR_INVALID_PHONE_NUMBER = "Invalid phone number format: ";
  private static final String ERROR_MESSAGE_FOR_INVALID_COMPANY_NAME = "Invalid company name format: ";
  private static final String ERROR_MESSAGE_FOR_INVALID_COMPANY_SERVICE = "Invalid company service format: ";
  private static final String ERROR_MESSAGE_FOR_INVALID_COMPANY_BUDGET = "Invalid company budget option: ";

  public static ProjectQuoteProfileDTO toDTO(ProjectQuoteProfile projectQuoteProfile) {
    ProjectQuoteProfileDTO projectQuoteProfileDTO = new ProjectQuoteProfileDTO();
    projectQuoteProfileDTO.setName(projectQuoteProfile.getName());
    projectQuoteProfileDTO.setEmail(projectQuoteProfile.getEmail());
    projectQuoteProfileDTO.setPhoneNumber(projectQuoteProfile.getPhoneNumber());
    projectQuoteProfileDTO.setCompanyName(projectQuoteProfile.getCompanyName());
    projectQuoteProfileDTO.setCompanyService(projectQuoteProfile.getCompanyService());
    projectQuoteProfileDTO.setCompanyBudget(projectQuoteProfile.getCompanyBudget());
    return projectQuoteProfileDTO;
  }

  public static ProjectQuoteProfile toEntity(ProjectQuoteProfileDTO projectQuoteProfileDTO) {
    ProjectQuoteProfile projectQuoteProfile = new ProjectQuoteProfile();
    projectQuoteProfile.setName(projectQuoteProfileDTO.getName());
    projectQuoteProfile.setEmail(projectQuoteProfileDTO.getEmail());
    projectQuoteProfile.setPhoneNumber(projectQuoteProfileDTO.getPhoneNumber());
    projectQuoteProfile.setCompanyName(projectQuoteProfileDTO.getCompanyName());
    projectQuoteProfile.setCompanyService(projectQuoteProfileDTO.getCompanyService());
    projectQuoteProfile.setCompanyBudget(projectQuoteProfileDTO.getCompanyBudget());
    return projectQuoteProfile;
  }

  public static void validateProjectQuoteProfileData(ProjectQuoteProfileDTO projectQuoteProfileDTO) {
    validateName(projectQuoteProfileDTO.getName());
    validateEmail(projectQuoteProfileDTO.getEmail());
    validatePhoneNumber(projectQuoteProfileDTO.getPhoneNumber());
    validateCompanyName(projectQuoteProfileDTO.getCompanyName());
    validateCompanyService(projectQuoteProfileDTO.getCompanyService());
    validateCompanyBudget(projectQuoteProfileDTO.getCompanyBudget());
  }

  private static void validateName(String name) {
    if ((name == null) || !NAME_PATTERN.matcher(name.trim()).matches()) {
      throw new InvalidNameException(ERROR_MESSAGE_FOR_INVALID_NAME + name);
    }
  }

  private static void validateEmail(String email) {
    if ((email == null) || !EMAIL_PATTERN.matcher(email).matches()) {
      throw new InvalidEmailException(ERROR_MESSAGE_FOR_INVALID_EMAIL + email);
    }
  }

  private static void validatePhoneNumber(String phoneNumber) {
    if ((phoneNumber == null) || !PHONE_NUMBER_PATTERN.matcher(phoneNumber).matches()) {
      throw new InvalidPhoneNumberException(ERROR_MESSAGE_FOR_INVALID_PHONE_NUMBER + phoneNumber);
    }
  }

  private static void validateCompanyName(String companyName) {
    if ((companyName == null) || !COMPANY_NAME_PATTERN.matcher(companyName).matches()) {
      throw new InvalidCompanyNameException(ERROR_MESSAGE_FOR_INVALID_COMPANY_NAME + companyName);
    }
  }

  private static void validateCompanyService(String companyService) {
    if ((companyService == null) || !COMPANY_SERVICE_PATTERN.matcher(companyService.trim()).matches()) {
      throw new InvalidCompanyServiceException(ERROR_MESSAGE_FOR_INVALID_COMPANY_SERVICE + companyService);
    }
  }

  private static void validateCompanyBudget(String companyBudget) {
    if ((companyBudget == null) || !BUDGET_OPTIONS.contains(companyBudget)) {
      throw new InvalidCompanyBudgetException(ERROR_MESSAGE_FOR_INVALID_COMPANY_BUDGET + companyBudget);
    }
  }
}
