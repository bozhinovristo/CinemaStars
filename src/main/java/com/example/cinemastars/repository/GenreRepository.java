package com.example.cinemastars.repository;

import com.example.cinemastars.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    public Optional<Genre> findByName(String name);
}
