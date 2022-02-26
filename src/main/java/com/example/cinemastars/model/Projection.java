package com.example.cinemastars.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
public class Projection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double price;

    private Timestamp timestamp;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Hall hall;

    public Projection() {
    }

    public Projection( Double price, Timestamp timestamp, Movie movie, Hall hall) {
        this.price = price;
        this.timestamp = timestamp;
        this.movie = movie;
        this.hall = hall;
    }
}
