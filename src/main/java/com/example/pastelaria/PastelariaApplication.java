package com.example.pastelaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
//@SpringBootApplication
public class PastelariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PastelariaApplication.class, args);
		System.out.println("Running!");

		
	}

}
