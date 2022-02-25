package com.example.cinemastars.model;

import lombok.Data;

@Data
public class Seat {

    private Integer seatNumber;

    private Hall hall;

    private Reservation reservation;

    public Seat(Integer seatNumber, Hall hall, Reservation reservation) {
        this.seatNumber = seatNumber;
        this.hall = hall;
        this.reservation = reservation;
    }
}
