package org.atif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TransformServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransformServiceApplication.class, args);
	}
}
