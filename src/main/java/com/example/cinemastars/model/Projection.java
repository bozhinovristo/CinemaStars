package com.example.cinemastars.model;

import lombok.Data;

import java.util.Date;

@Data
public class Projection {

    private Long id;

    private Double price;

    private Date date;

    private Movie movie;

    private Hall hall;

    public Projection(Long id, Double price, Date date, Movie movie, Hall hall) {
        this.id = id;
        this.price = price;
        this.date = date;
        this.movie = movie;
        this.hall = hall;
    }
}
