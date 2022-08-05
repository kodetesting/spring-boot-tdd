package com.koderoom.tdd;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@PropertySource(value = "file:${config-file-path}")
class SpringBootTddApplicationTests {
	@LocalServerPort
	private int port;

	@Autowired
	Environment env;

	@Test
	void contextLoads() {
		String value = env.getProperty("svc.services.vault.keystorePath");
		log.info("Value {}", value);
	}

}
