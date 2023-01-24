package com.koderoom.tdd.testproperty;


import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@Slf4j
@SpringBootTest
@TestPropertySource(locations = "/apptest.properties")
public class TestPropertyTest {

    @Value("${prop.username:raj}")
    private String propusername;

    @Test
    void test1() {
        log.info("PROP USERNAME {}", propusername);
        Assertions.assertThat(true).isTrue();
    }
}
