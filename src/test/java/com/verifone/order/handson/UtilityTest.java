package com.verifone.order.handson;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

public class UtilityTest {

    @Test
    void test1() {
        OffsetDateTime now =  OffsetDateTime.now();
        OffsetDateTime resTs=  now.minusHours(2);

        long diff = ChronoUnit.HOURS.between(resTs, now);
        System.out.println(diff);
    }
}
