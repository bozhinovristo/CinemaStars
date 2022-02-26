package com.example.cinemastars.service;

import com.example.cinemastars.model.Hall;

public interface HallService {
    public Hall save(String name, Integer numberOfSeats);
    public Hall findById(Long id);
}
