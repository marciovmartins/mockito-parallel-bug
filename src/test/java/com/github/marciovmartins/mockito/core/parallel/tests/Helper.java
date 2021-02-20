package com.github.marciovmartins.mockito.core.parallel.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class Helper {
    static void test(String value, Service service) {
        // setup
        var expectedValue = value + "-bar";
        when(service.doSomething(eq(value))).thenReturn(expectedValue);

        // execution
        var result = service.doSomething(value);

        // assertions
        verify(service).doSomething(eq(value));
        assertThat(result, is(equalTo(expectedValue)));
    }
}
