package com.koderoom.tdd.repository;

import com.koderoom.tdd.model.Greeting;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


@DataJpaTest
class GreetingRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    GreetingRepository greetingRepository;

    @Test
    void test1() {
        Greeting greeting = Greeting.builder().message("namaste").name("raja").build();
        Greeting greeting1 = greetingRepository.save(greeting);

        Assertions.assertThat(greeting1)
                .isNotNull()
                .hasFieldOrProperty("id")
        ;
    }


    @Test
    void test2() {
        Greeting greeting = Greeting.builder().message("namaste").name("rohit").build();
        testEntityManager.persist(greeting);

        Assertions.assertThat(greeting.getId()).isGreaterThan(0);
    }
}