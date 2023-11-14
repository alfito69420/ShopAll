package com.example.metaphorce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MetaphorceApplication {
    public static void main(final String[] args) {
        SpringApplication.run(MetaphorceApplication.class, args);
    }

    @GetMapping(path = "/hola")
    public String helloWorld() {
        return "helloWord desde maven";
    }
}
