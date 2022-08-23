package com.verifone.order.service;

import com.verifone.order.model.PurchaseTid;
import com.verifone.order.model.PurchaseTidStatusEnum;
import com.verifone.order.repository.PurchaseTidRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PurchaseTidServiceImplTest {

    @InjectMocks
    PurchaseTidServiceImpl purchaseTidService;

    @Mock
    PurchaseTidRepository purchaseTidRepository;

    @Test
    @DisplayName("Query Purchase Tid")
    void queryPurchaseTid() {
        List<PurchaseTid> list = new ArrayList<>();
        PurchaseTid purchaseTid = PurchaseTid.builder().tid("abcd").status(PurchaseTidStatusEnum.UNALLOCATED).build();
        list.add(purchaseTid);

        Mockito.when(purchaseTidRepository.findAll()).thenReturn(list);

        Assertions.assertThat(purchaseTidService.queryPurchaseTid())
                .isNotNull()
                .isNotEmpty()
                .hasSize(1)
                .first().hasFieldOrPropertyWithValue("tid", "abcd")
        ;
    }


    @Test
    @DisplayName("Create Purchase Tid")
    void createPurchaseTid() {
        PurchaseTid purchaseTid = PurchaseTid.builder().tid("abcd").status(PurchaseTidStatusEnum.UNALLOCATED).build();
        Mockito.when(purchaseTidRepository.save(purchaseTid)).thenReturn(purchaseTid);

        Assertions.assertThat(purchaseTidService.createPurchaseTidBy(purchaseTid))
                .isNotNull()
                .hasFieldOrPropertyWithValue("tid", "abcd")
        ;
    }


    @Test
    @DisplayName("Delete Purchase Tid")
    void deletePurchaseTid() {
        PurchaseTid purchaseTid = PurchaseTid.builder().tid("abcd").status(PurchaseTidStatusEnum.UNALLOCATED).build();
        Mockito.when(purchaseTidRepository.findById(purchaseTid.getTid())).thenReturn(Optional.of(purchaseTid));
        Mockito.doNothing().when(purchaseTidRepository).deleteById(purchaseTid.getTid());

        purchaseTidService.deletePurchaseTidBy(purchaseTid.getTid());
        Mockito.verify(purchaseTidRepository, Mockito.times(1)).deleteById(purchaseTid.getTid());
    }


    @Test
    void test1() {
        Assertions.assertThat("hello").isEqualTo("hello");
    }
}