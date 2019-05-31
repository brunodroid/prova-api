package com.elo.prova;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProvaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProvaApiApplication.class, args);

		System.out.println("===============================");
		System.out.println(" Server: http://localhost:8080 ");
		System.out.println("===============================");
	}
}
