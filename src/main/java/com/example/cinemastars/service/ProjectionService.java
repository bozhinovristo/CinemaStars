package com.example.cinemastars.service;

import com.example.cinemastars.model.Movie;
import com.example.cinemastars.model.Projection;

import java.sql.Timestamp;
import java.util.List;

public interface ProjectionService {
    public Projection save(Double price, Timestamp timestamp, Long movieId, Long hallId);
    public Projection findById(Long id);
    public List<Projection> findAllByMovie(Movie  movie);
}
