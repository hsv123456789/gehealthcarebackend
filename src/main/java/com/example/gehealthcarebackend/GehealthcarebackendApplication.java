package com.example.gehealthcarebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GehealthcarebackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(GehealthcarebackendApplication.class, args);
    }

}
