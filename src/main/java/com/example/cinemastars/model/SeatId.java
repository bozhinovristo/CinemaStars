package com.example.cinemastars.model;

import java.io.Serializable;

public class SeatId  implements Serializable {
    private Integer seatNumber;

    private Long projectionId;

    // default constructor


    public SeatId() {
    }

    public SeatId(Integer seatNumber, Long projectionId) {
        this.seatNumber = seatNumber;
        this.projectionId = projectionId;
    }

    // equals() and hashCode()
}