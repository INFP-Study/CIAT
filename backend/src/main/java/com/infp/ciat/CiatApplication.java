package com.infp.ciat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CiatApplication {

	public static void main(String[] args) {
		SpringApplication.run(CiatApplication.class, args);
	}

}
