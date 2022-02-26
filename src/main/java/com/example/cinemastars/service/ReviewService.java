package com.example.cinemastars.service;

import com.example.cinemastars.model.Review;

public interface ReviewService {
    public Review save(Double rating, Long movieId);
}
