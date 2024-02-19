package com.aju.fit.ajufit.service;

import com.aju.fit.ajufit.model.UserDto;
import com.aju.fit.ajufit.repository.model.UserEntity;

public interface CreateUserStrategy {
  UserEntity create(UserDto user) throws Exception;
}
