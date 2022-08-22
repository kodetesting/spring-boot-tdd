package com.koderoom.tdd.service;


import com.koderoom.tdd.model.User;
import com.koderoom.tdd.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @Mock
    MongoTemplate mongoTemplate;

    @Test
    void test1() {
        List<User> list = new ArrayList<>();
        User user1 = new User("1", UUID.randomUUID(), "raj", "sharma", "raj@raj.com", "112", LocalDateTime.now());
        list.add(user1);

        Mockito.when(mongoTemplate.findAll(User.class)).thenReturn(list);

        List<User> list1 = userService.findAll("test");
        Assertions.assertThat(list1)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1)
                .first().hasFieldOrPropertyWithValue("firstName", "raj")
        ;
    }


    @Test
    void test2() {
        User user1 = new User("1", UUID.randomUUID(), "raj", "sharma", "raj@raj.com", "112", LocalDateTime.now());

        Mockito.when(userRepository.save(user1)).thenReturn(user1);

        User user2 = userService.createUser(user1);
        Assertions.assertThat(user2)
                .isNotNull()
                .hasFieldOrPropertyWithValue("firstName", "raj")
        ;
    }
}