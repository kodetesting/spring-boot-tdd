package com.verifone.order.controller;

import com.verifone.order.service.PurchaseTidService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/purchase-tid")
public class PurchaseTidController {

    @Autowired
    private PurchaseTidService purchaseTidService;

    @GetMapping("/")
    public ResponseEntity<?> sayHello() {
        return new ResponseEntity<>("Hello World!" , HttpStatus.OK);
    }

}
