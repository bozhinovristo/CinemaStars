package com.example.cinemastars.config;

import com.example.cinemastars.model.Genre;
import com.example.cinemastars.model.Projection;
import com.example.cinemastars.service.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DataInitializer {

    private final UserService userService;
    private final GenreService genreService;
    private final MovieService movieService;
    private final HallService hallService;
    private final ProjectionService projectionService;
    private final SeatService seatService;

    public DataInitializer(UserService userService, GenreService genreService, MovieService movieService, HallService hallService, ProjectionService projectionService, SeatService seatService) {
        this.userService = userService;
        this.genreService = genreService;
        this.movieService = movieService;
        this.hallService = hallService;
        this.projectionService = projectionService;
        this.seatService = seatService;
    }

    @PostConstruct
    public void initData() {
        this.userService.save("user" + 0, "pass" + 0, "user0","user0");
        for (int i = 1; i < 6; i++) {
            this.userService.save("user" + i, "pass" + i, "user" + i,"user" + i);
        }

        this.initGenres();
        this.initHalls();
        this.initMovies();

        for (int i = 1; i <=6; i++) {

            Projection projection=this.projectionService.save( (double)(i%3+1)*2,
                    Timestamp.valueOf(LocalDateTime.now().plusDays(i)),
                    (long) i%3+1,
                    (long) i%3+1);
            int numberOfSeats=projection.getHall().getNumberOfSeats();
            for (int j=1;j<=numberOfSeats;j++)
            {
                this.seatService.save(j, projection.getId());
            }
        }

    }

    private void initGenres()
    {
        this.genreService.save("Action");
        this.genreService.save("Drama");
        this.genreService.save("Horror");
        this.genreService.save("Comedy");
        this.genreService.save("Thriller");
        this.genreService.save("Science fiction");
        this.genreService.save("Romance");
        this.genreService.save("Western");
        this.genreService.save("Crime");
        this.genreService.save("Adventure");
        this.genreService.save("Musical");
        this.genreService.save("Historical");
        this.genreService.save("Documentary");
        this.genreService.save("Fantasy");
        this.genreService.save("Mystery");

    }
    private void initHalls()
    {
        this.hallService.save("Star", 120);
        this.hallService.save("Moon", 100);
        this.hallService.save("Galaxy", 150);
    }

    private void initMovies()
    {
        List<Genre> genres=genreService.findAll();
        this.movieService.save(
                "Flight" ,
                139,
                "Robert",
                "Zemeckis",
                Stream.of(genreService.findByName("Drama").getId()).collect(Collectors.toList()),
                "Flight.jpg"
        );
        this.movieService.save(
                "Everest" ,
                120,
                "Baltasar",
                "Kormakur",
                Stream.of(genreService.findByName("Action").getId(),genreService.findByName("Adventure").getId()).collect(Collectors.toList()),
                    "Everest.jpg"        );
        this.movieService.save(
                "The tourist" ,
                103,
                "Florian",
                "Henckel von Donnersmarck",
                Stream.of(genreService.findByName("Mystery").getId(),genreService.findByName("Action").getId(),
                        genreService.findByName("Adventure").getId()).collect(Collectors.toList()),
                "The tourist.jpg"
        );
    }
}