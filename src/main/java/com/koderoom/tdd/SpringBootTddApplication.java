package com.koderoom.tdd;

import com.koderoom.tdd.service.AuthTokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

@Slf4j
@SpringBootApplication
@PropertySource(value = "file:${config-file-path}", ignoreResourceNotFound = true)
public class SpringBootTddApplication {

	@Autowired
	private Environment environment;

	@Autowired
	AuthTokenProvider authTokenProvider;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTddApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doCheck() {
		String value = environment.getProperty("server.port");
		log.info("Application Loaded!! {}", value);

		log.info("Auth Token Provider {}", authTokenProvider);
	}
}
