package com.example.cinemastars.config;

import com.example.cinemastars.model.Genre;
import com.example.cinemastars.service.GenreService;
import com.example.cinemastars.service.MovieService;
import com.example.cinemastars.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DataInitializer {

    private final UserService userService;
    private final GenreService genreService;
    private final MovieService movieService;

    public DataInitializer(UserService userService, GenreService genreService, MovieService movieService) {
        this.userService = userService;
        this.genreService = genreService;
        this.movieService = movieService;
    }

    @PostConstruct
    public void initData() {
        this.userService.save("user" + 0, "pass" + 0, "user0","user0");
        for (int i = 1; i < 6; i++) {
            this.userService.save("user" + i, "pass" + i, "user" + i,"user" + i);
        }
        for (int i = 1; i < 6; i++) {
            this.genreService.save("genre"+i);
        }

        List<Genre> genres=genreService.findAll();
        for (int i = 1; i < 11; i++) {
            this.movieService.save(
                    "Movie: " + i,
                     i,
                    "directorName",
                    "directorSurname",
                    Stream.of(genres.get((i - 1) % 5).getId(), genres.get((i + 1) % 5).getId()).collect(Collectors.toList())
            );
        }
    }
}
