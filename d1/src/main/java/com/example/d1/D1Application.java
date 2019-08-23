package com.example.d1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class D1Application {

    public static void main(String[] args) {
        SpringApplication.run(D1Application.class, args);
    }

}
