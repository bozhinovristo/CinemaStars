package com.example.cinemastars.service;

import com.example.cinemastars.model.Reservation;

import java.util.List;

public interface ReservationService {
    public Reservation save(String username, List<Integer> seats,Long projestionId);
}
