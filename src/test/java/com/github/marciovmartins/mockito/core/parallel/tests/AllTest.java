package com.github.marciovmartins.mockito.core.parallel.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockReset;

import static org.mockito.Mockito.mock;

@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AllTest {
    private static final Service staticFinalServiceMock = mock(Service.class);
    private static Service beforeAllStaticServiceMock;
    @MockBean(reset = MockReset.NONE)
    private Service serviceMockBean;
    @Mock
    private Service serviceMock;

    @BeforeAll
    static void beforeAll() {
        beforeAllStaticServiceMock = mock(Service.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a1", "b1", "c1", "d1", "e1", "f1", "g1"})
    void testWithMockBean(String value) {
        Helper.test(value, serviceMockBean);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a2", "b2", "c2", "d2", "e2", "f2", "g2"})
    void testWithMock(String value) {
        Helper.test(value, serviceMock);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a3", "b3", "c3", "d3", "e3", "f3", "g3"})
    void testWithStaticFinalMock(String value) {
        Helper.test(value, staticFinalServiceMock);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a4", "b4", "c4", "d4", "e4", "f4", "g4"})
    void testWithBeforeAllStaticMock(String value) {
        Helper.test(value, beforeAllStaticServiceMock);
    }
}
