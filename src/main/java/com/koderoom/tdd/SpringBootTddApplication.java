package com.koderoom.tdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "file:${config-file-path}", ignoreResourceNotFound = true)
public class SpringBootTddApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootTddApplication.class, args);
	}
}
