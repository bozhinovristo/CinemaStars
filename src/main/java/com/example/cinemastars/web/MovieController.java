package com.example.cinemastars.web;

import com.example.cinemastars.model.Genre;
import com.example.cinemastars.model.Movie;
import com.example.cinemastars.service.GenreService;
import com.example.cinemastars.service.MovieService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping
public class MovieController {
    private final MovieService movieService;
    private final GenreService genreService;

    public MovieController(MovieService movieService, GenreService genreService) {
        this.movieService = movieService;
        this.genreService = genreService;
    }

    @GetMapping({"/","/movies"})
    public String showList(Model model) {
        List<Movie> movies=movieService.findAll();
        model.addAttribute("movies", movies);
        return "movies";
    }
    @GetMapping("/catalog")
    public String filter(Model model) {
        List<Movie> movies=movieService.findAll();
        model.addAttribute("movies", movies);
        return "catalog";
    }

    @GetMapping("/movies/{id}")
    public String movieInfo(@PathVariable Long id, Model model)
    {
        Movie movie=movieService.findById(id);
        model.addAttribute("movie", movie);
        return "movie";
    }

    @GetMapping("/movies/add")
    public String showAdd(Model model) {
        List<Genre> genres=genreService.findAll();
        model.addAttribute("genres", genres);
        return "movieForm";
    }

    @GetMapping("/movies/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model) {
        Movie movie=movieService.findById(id);
        model.addAttribute("movie", movie);
        List<Genre> genres=genreService.findAll();
        model.addAttribute("genres", genres);
        return "movieForm";
    }
    /**
     * This method should add an entity given the arguments it takes.
     */
    @PostMapping("/movies")
    public String create(@RequestParam String name,
                         @RequestParam Integer duration,
                         @RequestParam String directorName,
                         @RequestParam String directorSurname,
                         @RequestParam List<Long> genreIds,
                         @RequestParam(required = false) String imageUrl) {
        this.movieService.save(name,duration, directorName, directorSurname, genreIds,imageUrl);
        return "redirect:/movies";
    }

    /**
     * This method should update an entity given the arguments it takes.
     */
    @PostMapping("/movies/{id}")
    public String update(@PathVariable Long id,
                         @RequestParam String name,
                         @RequestParam Integer duration,
                         @RequestParam String directorName,
                         @RequestParam String directorSurname,
                         @RequestParam List<Long> genreIds,
                         @RequestParam String imageUrl) {
        this.movieService.update(id, name, duration, directorName, directorSurname, genreIds, imageUrl);
        return "redirect:/movies";
    }

    /**
     * This method should delete the entity that has the appropriate identifier.
     */
    @PostMapping("/movies/{id}/delete")
    public String delete(@PathVariable Long id) {
        this.movieService.delete(id);
        return "redirect:/movies";
    }
}
