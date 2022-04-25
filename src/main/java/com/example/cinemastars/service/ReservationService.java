package com.example.cinemastars.service;

import com.example.cinemastars.model.Reservation;
import com.example.cinemastars.model.User;

import java.util.List;

public interface ReservationService {
    public Reservation save(String username, List<Integer> seats, Long projestionId, Double price);
    public List<Reservation> findByUser(User user);
    public Reservation findById(Long id);
    public void delete(Reservation reservation);
}
