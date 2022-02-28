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

    private Boolean reserved;

    public Seat() {

    }
    public Seat(Integer seatNumber,  Long projectionId) {
        this.seatNumber = seatNumber;
        this.projectionId = projectionId;
        this.reserved=false;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Long getProjectionId() {
        return projectionId;
    }

    public void setProjectionId(Long projectionId) {
        this.projectionId = projectionId;
    }

    public Boolean getReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }
}


