package com.github.marciovmartins.mockito.core.parallel.tests;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MockTest {
    @Mock
    private Service serviceMock;

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c", "d", "e", "f", "g"})
    void testWithMock(String value) {
        Helper.test(value, serviceMock);
    }
}
