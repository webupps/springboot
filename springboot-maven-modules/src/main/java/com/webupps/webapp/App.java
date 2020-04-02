package com.webupps.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.webupps")
@EntityScan("com.webupps")
@EnableJpaRepositories("com.webupps")
//@EnableJpaRepositories(basePackages = {"com.webupps.model", "com.webupps.repositories"})
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Profile("prod")
	@Bean
	public String dummy() {
		return "something";
	}
}