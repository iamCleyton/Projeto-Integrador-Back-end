package com.cleyton.manage_cars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ManagecarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagecarsApplication.class, args);
	}

}
