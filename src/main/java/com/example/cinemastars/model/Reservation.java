package com.example.cinemastars.model;

import lombok.Data;

@Data
public class Reservation {

    private Long id;

    private User user;

    private Seat seats;

    private Projection projection;

    public Reservation(Long id, User user, Seat seats, Projection projection) {
        this.id = id;
        this.user = user;
        this.seats = seats;
        this.projection = projection;
    }
}
