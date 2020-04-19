package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication(scanBasePackages="com.example")
public class ApifootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApifootApplication.class, args);
	}

}
