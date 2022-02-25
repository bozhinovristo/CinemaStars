package com.example.cinemastars.model;

import lombok.Data;

@Data
public class User {

    private Long id;

    private String name;

    private String surname;

    public User(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
}
