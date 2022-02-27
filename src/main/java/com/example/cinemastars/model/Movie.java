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

    private String imageUrl;

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

    public Movie(String name, Integer duration, Director director, List<Genre> genre, String imageUrl) {
        this.name = name;
        this.duration = duration;
        this.director = director;
        this.genre = genre;
        this.projection=new ArrayList<>();
        this.imageUrl=imageUrl;
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public void setProjection(List<Projection> projection) {
        this.projection = projection;
    }
}
