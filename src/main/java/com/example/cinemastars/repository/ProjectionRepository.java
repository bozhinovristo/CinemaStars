package com.example.cinemastars.repository;

import com.example.cinemastars.model.Movie;
import com.example.cinemastars.model.Projection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectionRepository extends JpaRepository<Projection, Long> {
    List<Projection> findAllByMovie(Movie movie);
}
