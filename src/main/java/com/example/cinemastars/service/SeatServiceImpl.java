package com.example.cinemastars.service;

import com.example.cinemastars.model.Seat;
import com.example.cinemastars.model.SeatId;
import com.example.cinemastars.repository.SeatRepository;
import org.springframework.stereotype.Service;

@Service
public class SeatServiceImpl implements SeatService{

    private final SeatRepository seatRepository;

    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public Seat save(Integer seatNumber, Long projectionId) {

        Seat seat=new Seat(seatNumber, projectionId);
        return seatRepository.save(seat);
    }
}
