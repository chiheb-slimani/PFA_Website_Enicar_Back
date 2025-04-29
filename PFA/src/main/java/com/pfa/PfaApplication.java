package com.pfa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.pfa",
        "com.pfa.controller",
        "com.pfa.Implementation",  // Capital I
        "com.pfa.service"
})
public class PfaApplication {
    public static void main(String[] args) {
        SpringApplication.run(PfaApplication.class, args);
    }
}

