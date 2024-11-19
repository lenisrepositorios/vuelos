package com.demo.booking;

import org.springframework.boot.SpringApplication;

public class TestMicroserviciosBookingApplication {

    public static void main(String[] args) {
        SpringApplication.from(BookingApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
