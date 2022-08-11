package com.koderoom.tdd.service;

import com.koderoom.tdd.model.User;
import com.koderoom.tdd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }
}
