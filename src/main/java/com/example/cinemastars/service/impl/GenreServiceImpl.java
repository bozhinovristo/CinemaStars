package com.example.cinemastars.service.impl;

import com.example.cinemastars.model.Genre;
import com.example.cinemastars.model.exceptions.GenreDoesNotExistException;
import com.example.cinemastars.repository.GenreRepository;
import com.example.cinemastars.service.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre save(String name) {
        Genre genre=new Genre(name);
        return genreRepository.save(genre);
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre findByName(String name) {
        return genreRepository.findByName(name).orElseThrow(()->new GenreDoesNotExistException());
    }
}
