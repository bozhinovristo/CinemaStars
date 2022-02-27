package com.example.cinemastars.service;

import com.example.cinemastars.model.*;
import com.example.cinemastars.repository.ReservationRepository;
import com.example.cinemastars.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        List<SeatId> seatIds=seats.stream().map(s->new SeatId(s, projestionId)).collect(Collectors.toList());
        List<Seat> seatList=seatRepository.findAllById(seatIds);

        Reservation reservation=new Reservation(user, seatList, projection);
        return reservationRepository.save(reservation);
    }
}
