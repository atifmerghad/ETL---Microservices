package org.atif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@EnableDiscoveryClient
@SpringBootApplication
public class ExtractServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExtractServiceApplication.class, args);
	}
}
