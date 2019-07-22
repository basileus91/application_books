package com.books.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.books.*")
public class Launcher {

	public static void main(String[] args) {
		SpringApplication.run(Launcher.class, args);
	}

}
