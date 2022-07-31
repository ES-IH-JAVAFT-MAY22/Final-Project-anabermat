package com.ironhack.saldoproxyserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SaldoProxyServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaldoProxyServerApplication.class, args);
	}

}
