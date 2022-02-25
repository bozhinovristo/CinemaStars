package com.example.cinemastars.model;

import lombok.Data;

@Data
public class Review {

    private Long id;

    private Double rating;

    private Movie movie;

    public Review(Long id, Double rating, Movie movie) {
        this.id = id;
        this.rating = rating;
        this.movie = movie;
    }
}
