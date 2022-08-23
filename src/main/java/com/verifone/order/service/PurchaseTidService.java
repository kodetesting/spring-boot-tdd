package com.verifone.order.service;

import com.verifone.order.model.PurchaseTid;

import java.util.List;

public interface PurchaseTidService {

    public List<PurchaseTid> queryPurchaseTid() ;
    public PurchaseTid getPurchaseTidById(String id) ;
    public PurchaseTid createPurchaseTidBy(PurchaseTid purchaseTid) ;
    public PurchaseTid updatePurchaseTidBy(String id, PurchaseTid purchaseTid) ;
    public void deletePurchaseTidBy(String id) ;
}
