package com.example.cinemastars.web;

import com.example.cinemastars.model.Genre;
import com.example.cinemastars.model.Movie;
import com.example.cinemastars.model.Projection;
import com.example.cinemastars.service.GenreService;
import com.example.cinemastars.service.MovieService;
import com.example.cinemastars.service.ProjectionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class MovieController {
    private final MovieService movieService;
    private final GenreService genreService;
    private final ProjectionService projectionService;

    public MovieController(MovieService movieService, GenreService genreService, ProjectionService projectionService) {
        this.movieService = movieService;
        this.genreService = genreService;
        this.projectionService = projectionService;
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
        List<Projection> projections=projectionService.findAllByMovie(movie);
        model.addAttribute("projections", projections);
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

    @PostMapping("/movies/{id}/delete")
    public String delete(@PathVariable Long id) {
        this.movieService.delete(id);
        return "redirect:/movies";
    }
}
