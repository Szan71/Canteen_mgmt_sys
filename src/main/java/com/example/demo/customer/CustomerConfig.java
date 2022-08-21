package com.example.demo.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository) {
        return args -> {
            Customer sujan = new Customer(
                    "Sujan Khadka",
                    "khadkasujan7@gmail.com",
                    "Angular",
                    648
            );

            Customer saran = new Customer(
                    "Saran Sonar",
                    "saran.sonar@infodevelopers.com.np",
                    "Angular",
                    123
            );

            repository.saveAll(
                    List.of(sujan,saran)
            );
        };
    }

}
