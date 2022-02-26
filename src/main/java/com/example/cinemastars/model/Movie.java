package com.example.cinemastars.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer duration;

    @ManyToOne
    private Director director;

    @ManyToMany
    private List<Genre> genre;

    @OneToMany(mappedBy = "movie")
    private List<Projection> projection;

    public Movie() {
    }

    public Movie(String name, Integer duration, Director director, List<Genre> genre) {
        this.name = name;
        this.duration = duration;
        this.director = director;
        this.genre = genre;
        this.projection=new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getDuration() {
        return duration;
    }

    public Director getDirector() {
        return director;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public List<Projection> getProjection() {
        return projection;
    }
}
