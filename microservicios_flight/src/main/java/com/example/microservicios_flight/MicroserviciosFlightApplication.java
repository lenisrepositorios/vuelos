package com.example.microservicios_flight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviciosFlightApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviciosFlightApplication.class, args);
    }

}