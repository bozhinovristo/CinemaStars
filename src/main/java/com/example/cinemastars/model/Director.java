package com.example.cinemastars.model;

import lombok.Data;

@Data
public class Director {

    private Long id;

    private String name;

    private String surname;

    public Director(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
}
