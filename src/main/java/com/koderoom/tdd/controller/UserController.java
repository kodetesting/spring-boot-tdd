package com.koderoom.tdd.controller;

import com.koderoom.tdd.model.User;
import com.koderoom.tdd.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/")
    ResponseEntity<?> findAll(@RequestParam(required = false) String entityUid) {
        List<User> list = userService.findAll(entityUid);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/byquery")
    ResponseEntity<?> findByQuery(@RequestParam(required = false) String entityUid) {
        List<User> list = userService.findByQuery(entityUid);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> findUserById(@PathVariable String id) {
        User userdb = userService.findUserById(id);
        return new ResponseEntity<>(userdb, HttpStatus.OK);
    }

    @PostMapping("/")
    ResponseEntity<?> createUser(@RequestBody User user) {
        User userdb = userService.createUser(user);
        return new ResponseEntity<>(userdb, HttpStatus.CREATED);
    }


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
