package com.koderoom.tdd.repository;


import com.koderoom.tdd.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalDateTime;
import java.util.UUID;

@DataMongoTest
@AutoConfigureDataMongo
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    void test1() {
        Assertions.assertThat("abcd")
                .isNotEmpty()
                .isEqualTo("abcd")
        ;
    }

    @Test
    void test2() {
        User user1 = new User("1", UUID.randomUUID(), "raj", "sharma", "raj@raj.com", "112", LocalDateTime.now());

        User user2 = userRepository.save(user1);
        Assertions.assertThat(user2)
                .isNotNull()
                .hasFieldOrProperty("id")
                .hasFieldOrPropertyWithValue("firstName", "raj");
        ;
    }


    @Test
    void test3() {
        User user1 = new User("1", UUID.randomUUID(), "raj", "sharma", "raj@raj.com", "112", LocalDateTime.now());
        User user2 = mongoTemplate.save(user1);

        Assertions.assertThat(user2)
                .isNotNull()
                .hasFieldOrProperty("id")
                .hasFieldOrPropertyWithValue("firstName", "raj");
        ;
    }
}