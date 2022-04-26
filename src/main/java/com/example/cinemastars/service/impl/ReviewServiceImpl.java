package com.example.cinemastars.service.impl;

import com.example.cinemastars.model.Movie;
import com.example.cinemastars.model.Review;
import com.example.cinemastars.repository.ReservationRepository;
import com.example.cinemastars.repository.ReviewRepository;
import com.example.cinemastars.service.MovieService;
import com.example.cinemastars.service.ReviewService;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring5.expression.Mvc;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final MovieService movieService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, MovieService movieService) {
        this.reviewRepository = reviewRepository;
        this.movieService = movieService;
    }


    @Override
    public Review save(Double rating, Long movieId) {
        Movie movie=movieService.findById(movieId);
        Review review=new Review(rating, movie);
        return reviewRepository.save(review);
    }
}
