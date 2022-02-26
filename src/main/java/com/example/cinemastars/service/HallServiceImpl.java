package com.example.cinemastars.service;

import com.example.cinemastars.model.Hall;
import com.example.cinemastars.repository.HallRepository;
import org.springframework.stereotype.Service;

@Service
public class HallServiceImpl implements HallService{

    private final HallRepository hallRepository;

    public HallServiceImpl(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    @Override
    public Hall save(String name, Integer numberOfSeats) {
        Hall hall=new Hall(name, numberOfSeats);
        return hallRepository.save(hall);
    }

    @Override
    public Hall findById(Long id) {
        return hallRepository.findById(id).get();
    }
}
