package com.verifone.order.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PurchaseTidSchedulerService {

    @Scheduled(fixedRate = 5000)
    public void scheduleJobToMarkReservedTidToUnblocked() {
        log.info("Schedule Service Executed");
    }
}
