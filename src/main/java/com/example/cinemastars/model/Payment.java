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

    private String name;
    private String surname;
    private String cardNumber;
    private String cardExpiration;
    private Integer securityCode;

    public Payment() {
    }



    public Payment(Reservation reservation, User user, String name, String surname, String cardNumber, String cardExpiration, Integer securityCode) {
        this.reservation = reservation;
        this.user = user;
        this.name = name;
        this.surname = surname;
        this.cardNumber = cardNumber;
        this.cardExpiration = cardExpiration;
        this.securityCode = securityCode;
    }
}
