package com.example.app;

import com.example.app.entity.Customer;
import com.example.app.entity.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {

    @Autowired
    protected CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {

            System.out.println("running application...");

            customerRepository.deleteAll();

            customerRepository.save(new Customer("Francisco", "Melo"));
            customerRepository.save(new Customer("Laura", "Mendes"));
            customerRepository.save(new Customer("John", "Mc Lann"));
            customerRepository.save(new Customer("Samuel", "jackson"));

            customerRepository.findAll().stream().forEach(System.out::println);
        };
    }
}
