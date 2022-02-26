package com.example.cinemastars.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Reservation reservation;

    @ManyToOne
    private User user;

    public Payment() {
    }

    public Payment(Reservation reservation, User user) {
        this.reservation = reservation;
        this.user = user;
    }
}
