package com.example.cinemastars.service;

import com.example.cinemastars.model.Seat;

public interface SeatService {
    public Seat save(Integer seatNumber, Long projectionId);
}
