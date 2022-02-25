package com.example.cinemastars.model;

import lombok.Data;

@Data
public class Hall {

    private Long id;

    private String name;

    private Integer numberOfSeats;

    public Hall(Long id, String name, Integer numberOfSeats) {
        this.id = id;
        this.name = name;
        this.numberOfSeats = numberOfSeats;
    }
}
