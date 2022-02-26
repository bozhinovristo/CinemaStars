package com.example.cinemastars.service;

import com.example.cinemastars.model.Projection;

import java.sql.Timestamp;

public interface ProjectionService {
    public Projection save(Double price, Timestamp timestamp, Long movieId, Long hallId);
    public Projection findById(Long id);
}
