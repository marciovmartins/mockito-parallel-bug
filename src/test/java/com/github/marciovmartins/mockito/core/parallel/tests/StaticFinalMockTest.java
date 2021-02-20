package com.github.marciovmartins.mockito.core.parallel.tests;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StaticFinalMockTest {
    private static final Service staticFinalServiceMock = mock(Service.class);

    @ParameterizedTest
    @ValueSource(strings = {"a8", "b8", "c8", "d8", "e8", "f8", "g8"})
    void testStaticFinalMock(String value) {
        // setup
        var expectedValue = value + "-bar";
        when(staticFinalServiceMock.doSomething(eq(value))).thenReturn(expectedValue);

        // execution
        var result = staticFinalServiceMock.doSomething(value);

        // assertions
        verify(staticFinalServiceMock).doSomething(eq(value));
        assertThat(result, is(equalTo(expectedValue)));
    }
}
