package com.fifi.tfmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.fifi.tfmanager"})
@EnableJpaRepositories
public class TfmanagerApplication {


    public static void main(String[] args) {
        SpringApplication.run(TfmanagerApplication.class, args);
    }

}
