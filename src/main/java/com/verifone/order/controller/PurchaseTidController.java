package com.verifone.order.controller;

import com.verifone.order.model.PurchaseTid;
import com.verifone.order.service.PurchaseTidService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/purchase-tid")
public class PurchaseTidController {

    @Autowired
    private PurchaseTidService purchaseTidService;

    /** CURD OPERATION */
    @GetMapping("/")
    public ResponseEntity<?> queryPurchaseTid() {
        log.info("Query Purchase Tid By {}");

        List<PurchaseTid> list =  purchaseTidService.queryPurchaseTid();
        return new ResponseEntity<>(list , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPurchaseTidById(@PathVariable String id) {
        log.info("GET Purchase Tid By Id {}", id);

        PurchaseTid purchaseTid =  purchaseTidService.getPurchaseTidById(id);
        return new ResponseEntity<>(purchaseTid, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> createPurchaseTidBy(@RequestBody PurchaseTid purchaseTid) {
        log.info("Create New Purchase Tid {}", purchaseTid);

        PurchaseTid purchaseTidRes =  purchaseTidService.createPurchaseTidBy(purchaseTid);
        return new ResponseEntity<>(purchaseTidRes , HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePurchaseTidBy(@PathVariable String id, @RequestBody PurchaseTid purchaseTid) {
        log.info("Update Existing Purchase Tid {}, {}", id, purchaseTid);

        PurchaseTid purchaseTidRes =  purchaseTidService.updatePurchaseTidBy(id, purchaseTid);
        return new ResponseEntity<>(purchaseTidRes , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePurchaseTidBy(@PathVariable String id) {
        log.info("Delete Existing Purchase Tid {}, {}", id);

        purchaseTidService.deletePurchaseTidBy(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }


    /** Hello Test */
    @GetMapping("/test")
    public ResponseEntity<?> sayHello() {
        return new ResponseEntity<>("Hello Test!" , HttpStatus.OK);
    }
}
