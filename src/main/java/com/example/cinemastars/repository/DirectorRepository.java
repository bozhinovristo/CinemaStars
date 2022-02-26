package com.example.cinemastars.repository;

import com.example.cinemastars.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
    public Optional<Director> findByNameAndSurname(String name, String Surname);
}
