package com.koderoom.tdd.repository;


import com.koderoom.tdd.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;

import java.time.LocalDateTime;
import java.util.UUID;

@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
class UserRepositoryUsingTestContainerTest {

    static MongoDBContainer mongoDBContainer;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @BeforeAll
    static void setUpDatabase() {
        mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:latest"));
        mongoDBContainer.start();
    }

    @AfterAll
    static void cleanUpDatabase() {
        mongoDBContainer.stop();;
    }

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

    @Test
    void test4() {
        User user1 = new User("1", UUID.randomUUID(), "raj", "sharma", "raj@raj.com", "112", LocalDateTime.now());
        User user2 = mongoTemplate.save(user1);

        Assertions.assertThat(user2)
                .isNotNull()
                .hasFieldOrProperty("id")
                .hasFieldOrPropertyWithValue("firstName", "raj");
        ;
    }

}