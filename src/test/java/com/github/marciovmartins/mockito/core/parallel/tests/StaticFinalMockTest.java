package com.github.marciovmartins.mockito.core.parallel.tests;

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
public class StaticFinalMockTest {
    private static final Service staticFinalServiceMock = mock(Service.class);

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c", "d", "e", "f", "g"})
    void testStaticFinalMock(String value) {
        Helper.test(value, staticFinalServiceMock);
    }
}
