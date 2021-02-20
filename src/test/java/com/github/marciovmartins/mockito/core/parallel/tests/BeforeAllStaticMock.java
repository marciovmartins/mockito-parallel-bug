package com.github.marciovmartins.mockito.core.parallel.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;

@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BeforeAllStaticMock {
    private static Service beforeAllStaticServiceMock;

    @BeforeAll
    static void beforeAll() {
        beforeAllStaticServiceMock = mock(Service.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c", "d", "e", "f", "g"})
    void testBeforeAllStaticMock(String value) {
        Helper.test(value, beforeAllStaticServiceMock);
    }
}
