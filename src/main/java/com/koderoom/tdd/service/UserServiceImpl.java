package com.koderoom.tdd.service;

import com.koderoom.tdd.model.User;
import com.koderoom.tdd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public List<User> findAll(String entityUid) {
        return mongoTemplate.findAll(User.class);
    }

    public List<User> findByQuery(String entityUid) {
        Query query = new Query();
        // query.addCriteria(Criteria.where("entityUid").is("e7c8dc87-6455-4a7d-8cb2-941966b41a02"));
        query.addCriteria(Criteria.where("entityUid").is(UUID.fromString("e7c8dc87-6455-4a7d-8cb2-941966b41a02")));

        return mongoTemplate.find(query, User.class);
    }

    public User findUserById(String id) {
        return userRepository.findById(id).get();
    }

    public User createUser(User user) {
        user.setTs(LocalDateTime.now());
        userRepository.save(user);
        return user;
    }
}
