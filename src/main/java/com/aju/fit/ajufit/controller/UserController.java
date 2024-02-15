//package com.aju.fit.ajufit.controller;
//
//import com.aju.fit.ajufit.repository.UserRepository;
//import com.aju.fit.ajufit.repository.model.UserEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class UserController {
//
//    public final UserRepository userRepository;
//
//    public UserController(
//            @Autowired final UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @GetMapping("/list-all")
//    public List<UserEntity> getAllUsers() {
//        return userRepository.findAll();
//    }
//}
