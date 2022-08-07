package com.koderoom.tdd.repository;

import com.koderoom.tdd.model.Greeting;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;


@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {"spring.datasource.url=jdbc:tc:postgresql:14-alpine://project4"})
class GreetingRepositoryUsingTestContainerTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    GreetingRepository greetingRepository;

    @Test
    @Order(1)
    @DisplayName("Persist Entity")
    void test1() {
        Greeting greeting = Greeting.builder().message("namaste").name("raja").build();
        Greeting greeting1 = greetingRepository.save(greeting);

        Assertions.assertThat(greeting1)
                .isNotNull()
                .hasFieldOrProperty("id")
        ;
    }


    @Test
    @Order(2)
    @DisplayName("Persist Entity using Entity Manager")
    void test2() {
        Greeting greeting = Greeting.builder().message("namaste").name("rohit").build();
        testEntityManager.persist(greeting);

        Assertions.assertThat(greeting.getId()).isPositive();
    }


    @Test
    @Order(3)
    @DisplayName("Find by Id")
    void test3() {
        Greeting greeting = Greeting.builder().message("namaste").name("rohit").build();
        int id = testEntityManager.persist(greeting).getId();

        Assertions.assertThat(greetingRepository.findById(id))
                .isNotNull()
                .isPresent()
        ;

    }


    @Test
    @Order(4)
    @DisplayName("Find All")
    void test4() {
        Greeting greeting = Greeting.builder().message("namaste").name("rohit").build();
        testEntityManager.persist(greeting);
        Greeting greeting1 = Greeting.builder().message("namaste").name("rahul").build();
        testEntityManager.persist(greeting1);

        Assertions.assertThat(greetingRepository.findAll())
                .isNotNull()
                .isNotEmpty()
                .hasSize(2)
        ;
    }
}