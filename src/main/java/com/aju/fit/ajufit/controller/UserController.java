package com.aju.fit.ajufit.controller;

import com.aju.fit.ajufit.model.UserDto;
import com.aju.fit.ajufit.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  public final UserService userService;

  public UserController(@Autowired final UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/user")
  public UserDto createUser(@RequestBody @Valid UserDto request) throws Exception {
    return userService.createUser(request);
  }
}
