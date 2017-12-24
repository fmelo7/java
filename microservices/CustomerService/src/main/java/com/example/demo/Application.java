package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
public class Application {

	@Autowired
	private CustomerService customerService;

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "customer-server");
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {

			customerService.save(new Customer("1", "joao", "souza"));
			customerService.save(new Customer("2", "maria", "silva"));
			customerService.save(new Customer("3", "antonio", "alves"));
			customerService.save(new Customer("4", "adriano", "goncalves"));
			customerService.save(new Customer("5", "jose", "luiz"));
		};
	}
}
