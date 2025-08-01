package com.example.company.exception;

public class InvalidPhoneNumberException extends RuntimeException {

  public InvalidPhoneNumberException(String message) {
    super(message);
  }

  public InvalidPhoneNumberException(String message, Throwable cause) {
    super(message, cause);
  }
}
