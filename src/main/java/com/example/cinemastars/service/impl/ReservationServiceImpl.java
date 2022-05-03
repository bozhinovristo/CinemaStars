package com.example.cinemastars.service.impl;

import com.example.cinemastars.events.ReservationEvent;
import com.example.cinemastars.model.*;
import com.example.cinemastars.repository.ReservationRepository;
import com.example.cinemastars.repository.SeatRepository;
import com.example.cinemastars.service.ProjectionService;
import com.example.cinemastars.service.ReservationService;
import com.example.cinemastars.service.UserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserService userService;
    private final SeatRepository seatRepository;
    private final ProjectionService projectionService;
    private final ApplicationEventPublisher applicationEventPublisher;

    public ReservationServiceImpl(ReservationRepository reservationRepository, UserService userService, SeatRepository seatRepository, ProjectionService projectionService, ApplicationEventPublisher applicationEventPublisher) {
        this.reservationRepository = reservationRepository;
        this.userService = userService;
        this.seatRepository = seatRepository;
        this.projectionService = projectionService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public Reservation save(String username, List<Integer> seats, Long projestionId, Double price) {

        User user=userService.findById(username);
        Projection projection=projectionService.findById(projestionId);
        List<SeatId> seatIds=seats.stream().map(s->new SeatId(s, projestionId)).collect(Collectors.toList());
        List<Seat> seatList=seatRepository.findAllById(seatIds);

        Reservation reservation=new Reservation(user, seatList, projection, price);

        this.applicationEventPublisher.publishEvent(new ReservationEvent(reservation));

        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> findByUser(User user) {
        return reservationRepository.findAllByUser(user);
    }

    @Override
    public Reservation findById(Long id) {
      return   reservationRepository.findById(id).get();
    }

    @Override
    public void delete(Reservation reservation) {
        reservationRepository.delete(reservation);
    }
}
