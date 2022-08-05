package com.koderoom.tdd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Greeting {
    int id;
    String name;
    String message;
}
