package com.example.cinemastars.service;

import com.example.cinemastars.model.Projection;
import com.example.cinemastars.model.Reservation;
import com.example.cinemastars.model.Seat;
import com.example.cinemastars.model.User;
import com.example.cinemastars.repository.ReservationRepository;
import com.example.cinemastars.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{

    private final ReservationRepository reservationRepository;
    private final UserService userService;
    private final SeatRepository seatRepository;
    private final ProjectionService projectionService;

    public ReservationServiceImpl(ReservationRepository reservationRepository, UserService userService, SeatRepository seatRepository, ProjectionService projectionService) {
        this.reservationRepository = reservationRepository;
        this.userService = userService;
        this.seatRepository = seatRepository;
        this.projectionService = projectionService;
    }

    @Override
    public Reservation save(String username, List<Integer> seats, Long projestionId) {

        User user=userService.findById(username);
        Projection projection=projectionService.findById(projestionId);
        List<Seat> seatList=seatRepository.findAllById(seats);

        Reservation reservation=new Reservation(user, seatList, projection);
        return reservationRepository.save(reservation);
    }
}
