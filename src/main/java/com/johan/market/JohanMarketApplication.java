package com.johan.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.johan.market.persistence.crud")
public class JohanMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(JohanMarketApplication.class, args);
	}

}
