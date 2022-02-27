package com.example.cinemastars.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@IdClass(SeatId.class)

public class Seat {
    @Id
    private Integer seatNumber;

    @Id
    private Long projectionId;

    public Seat() {

    }
    public Seat(Integer seatNumber,  Long projectionId) {
        this.seatNumber = seatNumber;
        this.projectionId = projectionId;
    }
}


