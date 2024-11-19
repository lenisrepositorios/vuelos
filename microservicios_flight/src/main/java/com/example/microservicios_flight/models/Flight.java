package com.example.microservicios_flight.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "flights")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
}
