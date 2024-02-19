package com.aju.fit.ajufit.exception.model;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionData {
  private final String code;
  private final String message;
  private final List<String> cause;
}
