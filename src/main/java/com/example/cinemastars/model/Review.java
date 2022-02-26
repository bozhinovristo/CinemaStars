package com.example.cinemastars.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double rating;

    @ManyToOne
    private Movie movie;

    public Review() {
    }

    public Review(Double rating, Movie movie) {
        this.rating = rating;
        this.movie = movie;
    }
}
