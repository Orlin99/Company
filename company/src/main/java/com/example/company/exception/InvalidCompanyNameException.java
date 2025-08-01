package com.example.company.exception;

public class InvalidCompanyNameException extends RuntimeException {

  public InvalidCompanyNameException(String message) {
    super(message);
  }

  public InvalidCompanyNameException(String message, Throwable cause) {
    super(message, cause);
  }
}
