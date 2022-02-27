package com.example.cinemastars.service;

import com.example.cinemastars.model.Director;
import com.example.cinemastars.model.Genre;
import com.example.cinemastars.model.Movie;

import java.util.List;

public interface MovieService {
    public Movie save(String name, Integer duration, String directorName, String directorSurname, List<Long> genreIds, String imageUrl);
    public Movie findById(Long id);
    public List<Movie> findAll();
}
