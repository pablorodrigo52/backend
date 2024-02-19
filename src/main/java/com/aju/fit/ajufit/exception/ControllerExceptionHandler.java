package com.aju.fit.ajufit.exception;

import com.aju.fit.ajufit.exception.model.ExceptionData;
import java.util.ArrayList;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler({IncompatibleUserException.class})
  public HttpEntity<ExceptionData> handleIncompatibleUserException(
      final IncompatibleUserException e) {

    return new ResponseEntity<>(
        ExceptionData.builder()
            .code(IncompatibleUserException.CODE)
            .message(e.getMessage())
            .cause(new ArrayList<>())
            .build(),
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({MethodArgumentNotValidException.class})
  public HttpEntity<ExceptionData> handleMethodArgumentNotValidException(
      final MethodArgumentNotValidException e) {

    final var errors =
        e.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();

    return new ResponseEntity<>(
        ExceptionData.builder()
            .code(HttpStatus.BAD_REQUEST.name())
            .message(e.getBody().getDetail())
            .cause(errors)
            .build(),
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({Exception.class, RuntimeException.class})
  public HttpEntity<ExceptionData> handleGenericException(final Exception e) {
    return new ResponseEntity<>(
        ExceptionData.builder()
            .code(HttpStatus.INTERNAL_SERVER_ERROR.name())
            .message(e.getMessage())
            .build(),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
