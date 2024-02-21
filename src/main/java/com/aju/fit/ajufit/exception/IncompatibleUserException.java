package com.aju.fit.ajufit.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class IncompatibleUserException extends Exception {
  public static final String CODE = "INCOMPATIBLE_USER";

  public IncompatibleUserException(String message) {
    super(message);
  }
}
