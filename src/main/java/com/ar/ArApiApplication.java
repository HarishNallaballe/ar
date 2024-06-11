package com.ar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

  
@SpringBootApplication
public class ArApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArApiApplication.class, args);
	}

}
