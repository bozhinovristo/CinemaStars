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

    public Reservation() {
    }

    public Reservation(User user, List<Seat> seats, Projection projection) {
        this.user = user;
        this.seats = seats;
        this.projection = projection;
    }
}
