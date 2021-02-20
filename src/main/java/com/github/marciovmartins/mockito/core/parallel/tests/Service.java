package com.github.marciovmartins.mockito.core.parallel.tests;

import org.springframework.stereotype.Component;

@Component
public class Service {
    String doSomething(String value) {
        return value + "-foo";
    }
}
