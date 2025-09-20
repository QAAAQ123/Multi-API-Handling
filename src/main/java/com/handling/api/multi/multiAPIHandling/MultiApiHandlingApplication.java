package com.handling.api.multi.multiAPIHandling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MultiApiHandlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiApiHandlingApplication.class, args);
	}

}
