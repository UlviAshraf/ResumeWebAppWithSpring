package com.company.resumerestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.company"})
public class ResumerestapiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResumerestapiApplication.class, args);
    }
}
