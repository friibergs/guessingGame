package com.example.guessinggame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class GuessingGameApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuessingGameApplication.class, args);
    }

}
