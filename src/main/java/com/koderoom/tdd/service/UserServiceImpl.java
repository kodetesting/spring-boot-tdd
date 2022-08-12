package com.koderoom.tdd.service;

import com.koderoom.tdd.model.User;
import com.koderoom.tdd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl {

    @Autowired
    UserRepository userRepository;

    public User findUserById(String id) {
        return userRepository.findById(id).get();
    }

    public User createUser(User user) {
        user.setTs(LocalDateTime.now());
        userRepository.save(user);
        return user;
    }
}
