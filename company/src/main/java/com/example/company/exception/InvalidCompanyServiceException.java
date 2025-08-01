package com.example.company.exception;

public class InvalidCompanyServiceException extends RuntimeException {

  public InvalidCompanyServiceException(String message) {
    super(message);
  }

  public InvalidCompanyServiceException(String message, Throwable cause) {
    super(message, cause);
  }
}
