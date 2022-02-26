package com.example.cinemastars.service;

import com.example.cinemastars.model.Director;

import java.util.Optional;

public interface DirectorService {
    public Director save(String name, String surname);
    public Director findById(Long id);
    public Optional<Director> findByNameAndSurname(String name, String surname);
}
