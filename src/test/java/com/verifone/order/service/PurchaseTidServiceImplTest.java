package com.verifone.order.service;

import com.verifone.order.repository.PurchaseTidRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PurchaseTidServiceImplTest {

    @InjectMocks
    PurchaseTidServiceImpl purchaseTidService;

    @Mock
    PurchaseTidRepository purchaseTidRepository;

    @Test
    void test1() {
        Assertions.assertThat("hello").isEqualTo("hello");
    }
}