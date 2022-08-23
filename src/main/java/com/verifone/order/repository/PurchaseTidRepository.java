package com.verifone.order.repository;

import com.verifone.order.model.PurchaseTid;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseTidRepository extends MongoRepository<PurchaseTid, String> {
}
