package com.verifone.order.repository;


import com.verifone.order.model.PurchaseTid;
import com.verifone.order.model.PurchaseTidStatusEnum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@DataMongoTest
@AutoConfigureDataMongo
class PurchaseTidRepositoryTest {

    @Autowired
    PurchaseTidRepository purchaseTidRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    void createPurchaseTid() {
        PurchaseTid purchaseTid = PurchaseTid.builder().tid("abcd").status(PurchaseTidStatusEnum.UNALLOCATED).build();
        PurchaseTid purchaseTid1 = purchaseTidRepository.save(purchaseTid);

        Assertions.assertThat(purchaseTid1).isNotNull().hasFieldOrPropertyWithValue("tid", "abcd");
    }


    @Test
    void queryPurchaseTid() {
        PurchaseTid purchaseTid = PurchaseTid.builder().tid("abcd").status(PurchaseTidStatusEnum.UNALLOCATED).build();
        PurchaseTid purchaseTid1 = PurchaseTid.builder().tid("abcde").status(PurchaseTidStatusEnum.UNALLOCATED).build();
        purchaseTidRepository.save(purchaseTid);
        purchaseTidRepository.save(purchaseTid1);

        List<PurchaseTid> list = purchaseTidRepository.findAll();
        Assertions.assertThat(list).isNotNull().isNotEmpty().hasSize(2);
    }


    @Test
    void test1() {
        Assertions.assertThat("hello").isEqualTo("hello");
    }
}