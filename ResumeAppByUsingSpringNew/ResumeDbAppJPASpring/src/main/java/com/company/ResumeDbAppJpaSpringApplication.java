package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ResumeDbAppJpaSpringApplication {
    public static void main(String[] args) {

        SpringApplication.run(ResumeDbAppJpaSpringApplication.class, args);
    }
}
