package com.example.microservicios_flight;

import org.springframework.boot.SpringApplication;

public class TestMicroserviciosFlightApplication {

    public static void main(String[] args) {
        SpringApplication.from(MicroserviciosFlightApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
