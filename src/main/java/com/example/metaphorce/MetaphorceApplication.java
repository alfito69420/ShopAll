package com.example.metaphorce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//@EnableSwagger2
public class MetaphorceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MetaphorceApplication.class, args);
    }
}
