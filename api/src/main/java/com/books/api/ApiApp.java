package com.books.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.books.*")
public class ApiApp {
    public static void main(String[] args) {
        SpringApplication.run(ApiApp.class, args);
    }
}
