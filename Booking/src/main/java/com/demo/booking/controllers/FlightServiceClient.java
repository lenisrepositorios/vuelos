package com.demo.booking.controllers;

import com.demo.booking.models.Flight;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "microservicios-flight")
public interface FlightServiceClient {

    @GetMapping("/api/flight/{flightNumber}")
    Flight getFlightByFlightNumber(@PathVariable Long flightNumber);
}
