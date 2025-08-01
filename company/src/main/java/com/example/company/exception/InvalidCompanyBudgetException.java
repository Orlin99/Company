package com.example.company.exception;

public class InvalidCompanyBudgetException extends RuntimeException {

  public InvalidCompanyBudgetException(String message) {
    super(message);
  }

  public InvalidCompanyBudgetException(String message, Throwable cause) {
    super(message, cause);
  }
}
