package com.example.cinemastars.service.impl;

import com.example.cinemastars.model.Hall;
import com.example.cinemastars.model.Movie;
import com.example.cinemastars.model.Projection;
import com.example.cinemastars.repository.ProjectionRepository;
import com.example.cinemastars.service.HallService;
import com.example.cinemastars.service.MovieService;
import com.example.cinemastars.service.ProjectionService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ProjectionServiceImpl implements ProjectionService {

    private final ProjectionRepository projectionRepository;
    private final MovieService movieService;
    private final HallService hallService;

    public ProjectionServiceImpl(ProjectionRepository projectionRepository, MovieService movieService, HallService hallService) {
        this.projectionRepository = projectionRepository;
        this.movieService = movieService;
        this.hallService = hallService;
    }

    @Override
    public Projection save(Double price, Timestamp timestamp, Long movieId, Long hallId) {
        Movie movie=movieService.findById(movieId);
        Hall hall= hallService.findById(hallId);
        Projection projection=new Projection(price, timestamp, movie, hall);
        return projectionRepository.save(projection);
    }

    @Override
    public Projection findById(Long id) {
        Projection projection=projectionRepository.getById(id);
        return projection;
    }

    @Override
    public List<Projection> findAllByMovie(Movie movie) {
        return projectionRepository.findAllByMovie(movie);
    }

}
