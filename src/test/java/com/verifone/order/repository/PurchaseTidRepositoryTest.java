package com.verifone.order.repository;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@DataMongoTest
@AutoConfigureDataMongo
class PurchaseTidRepositoryTest {

    @Autowired
    PurchaseTidRepository purchaseTidRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    void test1() {
        Assertions.assertThat("hello").isEqualTo("hello");
    }
}