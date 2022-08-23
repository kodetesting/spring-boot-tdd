package com.verifone.order.model;

public enum PurchaseTidStatusEnum {
    UNALLOCATED("1"),
    RESERVED("2"),
    ALLOCATED("3");

    private String value;
    private PurchaseTidStatusEnum(String value) {
        this.value = value;
    }
}
