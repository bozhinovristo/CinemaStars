package com.example.cinemastars.service;

import com.example.cinemastars.model.Seat;

import java.util.List;

public interface SeatService {
    public Seat save(Integer seatNumber, Long projectionId);
    public Seat save(Seat seat);
    public List<Seat> findAllByProjectionId(Long projectionId);
}
