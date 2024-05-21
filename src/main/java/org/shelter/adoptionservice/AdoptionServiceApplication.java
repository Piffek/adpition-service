package org.shelter.adoptionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.shelter.adoptionservice.infra")
@EntityScan(basePackages = "org.shelter.adoptionservice.infra.entity")
@ComponentScan(basePackages = "org.shelter")
public class AdoptionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdoptionServiceApplication.class, args);
    }

}
