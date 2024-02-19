package com.aju.fit.ajufit.service;

import com.aju.fit.ajufit.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final CreateUserFactory createUserFactory;

  public UserService(@Autowired final CreateUserFactory userFactory) {
    this.createUserFactory = userFactory;
  }

  public UserDto createUser(final UserDto request) throws Exception {

    final var user = createUserFactory.get(request.type()).create(request);

    return user.toDto();
  }
}
