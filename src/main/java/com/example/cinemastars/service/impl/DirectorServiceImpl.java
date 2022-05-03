package com.example.cinemastars.service.impl;

import com.example.cinemastars.model.Director;
import com.example.cinemastars.repository.DirectorRepository;
import com.example.cinemastars.service.DirectorService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository directorRepository;

    public DirectorServiceImpl(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public Director save(String name, String surname) {
        Director director=new Director(name, surname);
        return directorRepository.save(director);
    }

    @Override
    public Director findById(Long id) {
        return directorRepository.findById(id).get();
    }

    @Override
    public Optional<Director> findByNameAndSurname(String name, String surname) {
        return directorRepository.findByNameAndSurname(name, surname);
    }
}
