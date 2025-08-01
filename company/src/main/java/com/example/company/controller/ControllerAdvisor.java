package com.example.company.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.company.exception.InvalidCompanyBudgetException;
import com.example.company.exception.InvalidCompanyNameException;
import com.example.company.exception.InvalidCompanyServiceException;
import com.example.company.exception.InvalidEmailException;
import com.example.company.exception.InvalidNameException;
import com.example.company.exception.InvalidPhoneNumberException;

@ControllerAdvice(basePackages = "com.example.company")
public class ControllerAdvisor {

  @ExceptionHandler(InvalidNameException.class)
  public ResponseEntity<String> handleInvalidNameException(InvalidNameException exception) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
  }

  @ExceptionHandler(InvalidEmailException.class)
  public ResponseEntity<String> handleInvalidEmailException(InvalidEmailException exception) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
  }

  @ExceptionHandler(InvalidPhoneNumberException.class)
  public ResponseEntity<String> handleInvalidPhoneNumberException(InvalidPhoneNumberException exception) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
  }

  @ExceptionHandler(InvalidCompanyNameException.class)
  public ResponseEntity<String> handleInvalidCompanyNameException(InvalidCompanyNameException exception) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
  }

  @ExceptionHandler(InvalidCompanyServiceException.class)
  public ResponseEntity<String> handleInvalidCompanyServiceException(InvalidCompanyServiceException exception) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
  }

  @ExceptionHandler(InvalidCompanyBudgetException.class)
  public ResponseEntity<String> handleInvalidCompanyBudgetException(InvalidCompanyBudgetException exception) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
  }
}
