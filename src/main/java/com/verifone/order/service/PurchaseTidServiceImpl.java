package com.verifone.order.service;

import com.verifone.order.model.PurchaseTid;
import com.verifone.order.repository.PurchaseTidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseTidServiceImpl implements PurchaseTidService {

    @Autowired
    PurchaseTidRepository purchaseTidRepository;

    @Override
    public List<PurchaseTid> queryPurchaseTid() {
        return purchaseTidRepository.findAll();
    }

    @Override
    public PurchaseTid getPurchaseTidById(String id) {
        Optional<PurchaseTid> purchaseTidOptional = purchaseTidRepository.findById(id);
        return purchaseTidOptional.orElseThrow(() -> new RuntimeException("Resource Not Found"));
    }

    @Override
    public PurchaseTid createPurchaseTidBy(PurchaseTid purchaseTid) {
        purchaseTidRepository.findById(purchaseTid.getTid()).ifPresent((purchaseTid1) -> {
            throw new RuntimeException("TID Already Exits!!");
        });

        PurchaseTid purchaseTid1 =  purchaseTidRepository.save(purchaseTid);
        return purchaseTid1;
    }

    @Override
    public PurchaseTid updatePurchaseTidBy(String id, PurchaseTid purchaseTid) {
        purchaseTidRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource does not exists"));
        return  purchaseTidRepository.save(purchaseTid);
    }

    @Override
    public void deletePurchaseTidBy(String id) {
        purchaseTidRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource does not exists"));
        purchaseTidRepository.deleteById(id);
    }
}
