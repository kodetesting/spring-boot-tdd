package com.verifone.order.controller;

import com.verifone.order.model.PurchaseTid;
import com.verifone.order.model.PurchaseTidStatusEnum;
import com.verifone.order.service.PurchaseTidService;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(PurchaseTidController.class)
class PurchaseTidControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    PurchaseTidService purchaseTidService;

    static ObjectMapper objectMapper;

    @BeforeAll
    static void setUp(){
        objectMapper = new ObjectMapper();
    }

    @Test
    @DisplayName("Query Purchase Tid")
    void queryPurchaseTidTest() throws Exception {
        List<PurchaseTid> list = new ArrayList<>();
        PurchaseTid purchaseTid = PurchaseTid.builder().tid("abcd").status(PurchaseTidStatusEnum.UNALLOCATED).build();
        list.add(purchaseTid);

        Mockito.when(purchaseTidService.queryPurchaseTid()).thenReturn(list);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/purchase-tid/"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].tid", Matchers.is("abcd")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].status", Matchers.is("UNALLOCATED")))
        ;
    }


    @Test
    @DisplayName("Create Purchase Tid")
    void createPurchaseTidTest() throws Exception {
        PurchaseTid purchaseTid = PurchaseTid.builder().tid("abcd").status(PurchaseTidStatusEnum.UNALLOCATED).build();

        Mockito.when(purchaseTidService.createPurchaseTidBy(purchaseTid)).thenReturn(purchaseTid);

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/purchase-tid/")
                                .content(objectMapper.writeValueAsString(purchaseTid))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.tid", Matchers.is("abcd")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status", Matchers.is("UNALLOCATED")))
        ;
    }

    @Test
    @DisplayName("Delete Purchase Tid")
    void deletePurchaseTidTest() throws Exception {
        PurchaseTid purchaseTid = PurchaseTid.builder().tid("abcd").status(PurchaseTidStatusEnum.UNALLOCATED).build();

        Mockito.doNothing().when(purchaseTidService).deletePurchaseTidBy(purchaseTid.getTid());

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/purchase-tid/{id}", purchaseTid.getTid())
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isGone())
        ;
    }


    @Test
    void test1() {
        Assertions.assertThat("hello").isEqualTo("hello");
    }
}