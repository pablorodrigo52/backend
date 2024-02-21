package com.aju.fit.ajufit.service;

import com.aju.fit.ajufit.statics.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserFactory {
  private final CreateProfessor createProfessor;
  private final CreateStudent createStudent;

  public CreateUserFactory(
      @Autowired final CreateProfessor createProfessor,
      @Autowired final CreateStudent createStudent) {
    this.createProfessor = createProfessor;
    this.createStudent = createStudent;
  }

  public CreateUserStrategy get(UserType type) {
    return switch (type) {
      case P -> createProfessor;
      case S -> createStudent;
    };
  }
}
