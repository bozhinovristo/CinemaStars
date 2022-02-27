package com.example.cinemastars.service;

import com.example.cinemastars.model.Genre;

import java.util.List;

public interface GenreService {
    public Genre save(String name);
    public List<Genre> findAll();
    public Genre findByName(String name);
}
