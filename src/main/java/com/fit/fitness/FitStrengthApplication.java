package com.fit.fitness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author Marko
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.fit.controller", "com.fit.service", "com.fit.repository" })
@EntityScan(basePackages = { "com.fit.model" })
@EnableJpaRepositories(basePackages = "com.fit.repository")
public class FitStrengthApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitStrengthApplication.class, args);
	}
}
