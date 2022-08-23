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
        purchaseTidOptional.orElseThrow();
        return purchaseTidOptional.get();
    }

    @Override
    public PurchaseTid createPurchaseTidBy(PurchaseTid purchaseTid) {
        Optional<PurchaseTid> purchaseTidOptional =  purchaseTidRepository.findById(purchaseTid.getTid());

        if(purchaseTidOptional.isEmpty()) {
            PurchaseTid purchaseTid1 =  purchaseTidRepository.save(purchaseTid);
            return purchaseTid1;
        } else {
            throw new RuntimeException("TID Already Exists!");
        }
    }

    @Override
    public PurchaseTid updatePurchaseTidBy(String id, PurchaseTid purchaseTid) {
        purchaseTid.setTid(id);
        PurchaseTid purchaseTid1 = purchaseTidRepository.save(purchaseTid);
        return purchaseTid1;
    }

    @Override
    public void deletePurchaseTidBy(String id) {
        purchaseTidRepository.deleteById(id);
        return;
    }
}
