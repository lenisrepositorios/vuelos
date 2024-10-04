package com.example.discoverservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoverservicesApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiscoverservicesApplication.class, args);
    }
}
