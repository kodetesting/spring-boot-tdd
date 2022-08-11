package com.koderoom.tdd.controller;

import com.koderoom.tdd.model.User;
import com.koderoom.tdd.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/default")
    ResponseEntity<?> createDefaultUser() {
        User user = User.builder()
                .firstName("raj")
                .lastName("dhani")
                .email("raj@gmail.com")
                .mobile("121221")
                .entityUid(UUID.randomUUID())
                .build();
        User userdb = userService.createUser(user);

        return new ResponseEntity<>(userdb, HttpStatus.CREATED);
    }

}
