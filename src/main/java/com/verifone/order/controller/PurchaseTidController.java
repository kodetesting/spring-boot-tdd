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
        return new ResponseEntity<>("Query Purchase Tid" , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPurchaseTidById(@PathVariable String id) {
        log.info("GET Purchase Tid By Id {}", id);
        return new ResponseEntity<>("Get By Id" , HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> createPurchaseTidBy(@RequestBody PurchaseTid purchaseTid) {
        log.info("Create New Purchase Tid {}", purchaseTid);
        return new ResponseEntity<>("Create Operation!" , HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePurchaseTidBy(@PathVariable String id, @RequestBody PurchaseTid purchaseTid) {
        log.info("Update Existing Purchase Tid {}, {}", id, purchaseTid);
        return new ResponseEntity<>("Update Operation!" , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> updatePurchaseTidBy(@PathVariable String id) {
        log.info("Delete Existing Purchase Tid {}, {}", id);
        return new ResponseEntity<>("Delete Operation!" , HttpStatus.OK);
    }


    /** Hello Test */
    @GetMapping("/test")
    public ResponseEntity<?> sayHello() {
        return new ResponseEntity<>("Hello Test!" , HttpStatus.OK);
    }
}
