package com.example.cinemastars.web;

import com.example.cinemastars.model.Movie;
import com.example.cinemastars.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping({"/","/movies"})
    public String showList(Model model) {
        List<Movie> movies=movieService.findAll();
        model.addAttribute("movies", movies);
        return "movies";
    }
}
