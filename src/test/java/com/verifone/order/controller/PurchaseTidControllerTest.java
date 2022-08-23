package com.verifone.order.controller;

import com.verifone.order.service.PurchaseTidService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PurchaseTidController.class)
class PurchaseTidControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    PurchaseTidService purchaseTidService;


    @Test
    void test1() {
        Assertions.assertThat("hello").isEqualTo("hello");
    }
}