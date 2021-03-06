package com.example.cinemastars.service.impl;

import com.example.cinemastars.model.Director;
import com.example.cinemastars.model.Genre;
import com.example.cinemastars.model.Movie;
import com.example.cinemastars.repository.GenreRepository;
import com.example.cinemastars.repository.MovieRepository;
import com.example.cinemastars.service.DirectorService;
import com.example.cinemastars.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final DirectorService directorService;
    private final GenreRepository genreRepository;

    public MovieServiceImpl(MovieRepository movieRepository, DirectorService directorService, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.directorService = directorService;
        this.genreRepository = genreRepository;
    }

    @Override
    public Movie save(String name, Integer duration, String directorName, String directorSurname, List<Long> genreIds, String imageUrl) {
        Director director;
        if(directorService.findByNameAndSurname(directorName, directorSurname).isPresent())
            director=directorService.findByNameAndSurname(directorName, directorSurname).get();
        else
            director=directorService.save(directorName, directorSurname);

        List<Genre> genres=genreRepository.findAllById(genreIds);

        Movie movie=new Movie(name, duration, director, genres, imageUrl);
        return movieRepository.save(movie);
    }
    @Override
    public Movie update(Long id, String name, Integer duration, String directorName, String directorSurname, List<Long> genreIds, String imageUrl) {
        Director director;
        if(directorService.findByNameAndSurname(directorName, directorSurname).isPresent())
            director=directorService.findByNameAndSurname(directorName, directorSurname).get();
        else
            director=directorService.save(directorName, directorSurname);

        List<Genre> genres=genreRepository.findAllById(genreIds);

        Movie movie=this.findById(id);
        movie.setName(name);
        movie.setDuration(duration);
        movie.setDirector(director);
        movie.setGenre(genres);
        movie.setImageUrl(imageUrl);

        return movieRepository.save(movie);
    }

    @Override
    public void delete(Long id) {
        Movie movie=movieRepository.findById(id).get();
        this.movieRepository.delete(movie);
    }

    @Override
    public Movie findById(Long id) {
       return movieRepository.findById(id).get();
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }
}
