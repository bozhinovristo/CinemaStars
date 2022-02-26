package com.example.cinemastars.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatNumber;
    @ManyToOne
    private Projection projection;

    public Seat() {

    }
    public Seat(Integer seatNumber,  Projection projection) {
        this.seatNumber = seatNumber;
        this.projection = projection;
    }

}
