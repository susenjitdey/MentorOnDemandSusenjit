package com.menondemand.jwtauthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(scanBasePackages = { "com.menondemand" })
public class SpringBootJwtAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtAuthenticationApplication.class, args);
	}
}
