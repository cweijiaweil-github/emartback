package com.emart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableJpaAuditing
@EnableEurekaClient
// @ComponentScan(basePackages = {"com.emart.*.controller","com.emart.*.service"})
public class SellerApplication {

	public static void main(final String[] args) {
		SpringApplication.run(SellerApplication.class, args);
	}

}
