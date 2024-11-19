package com.demo.booking.models;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Flight {
    private Long id;
    private Long flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
}
