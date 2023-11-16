package com.app.kuri;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class KuriApplication {

	public static void main(String[] args) {
		SpringApplication.run(KuriApplication.class, args);
	}

}
