package com.demo.booking.models;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "booking")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long flightNumber;
    private String passengerName;
}
