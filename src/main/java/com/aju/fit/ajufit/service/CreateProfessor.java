package com.aju.fit.ajufit.service;

import com.aju.fit.ajufit.model.UserDto;
import com.aju.fit.ajufit.repository.UserRepository;
import com.aju.fit.ajufit.repository.model.UserEntity;
import com.aju.fit.ajufit.statics.UserType;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProfessor implements CreateUserStrategy {
  private final UserRepository userRepository;

  public CreateProfessor(@Autowired UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserEntity create(UserDto request) throws Exception {
    // if is a professor -> insert new line
    if (UserType.isProfessor(request.type())) {
      return save(request);
    }

    throw new Exception("Cannot create user, incompatible types");
  }

  private UserEntity save(UserDto request) throws Exception {
    try {
      return userRepository.save(request.toUserEntity().build());
    } catch (SQLException e) {
      throw new Exception(e.getMessage());
    }
  }
}
