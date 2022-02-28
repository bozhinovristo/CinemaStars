package com.example.cinemastars.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Seat> seats;

    @ManyToOne
    private Projection projection;

    private Double price;

    public Reservation() {
    }

    public Reservation(User user, List<Seat> seats, Projection projection, Double price) {
        this.user = user;
        this.seats = seats;
        this.projection = projection;
        this.price=price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public Projection getProjection() {
        return projection;
    }

    public void setProjection(Projection projection) {
        this.projection = projection;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
