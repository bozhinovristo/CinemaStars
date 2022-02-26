package com.example.cinemastars.service;

import com.example.cinemastars.model.Payment;
import com.example.cinemastars.model.Reservation;
import com.example.cinemastars.model.User;
import com.example.cinemastars.repository.PaymentRepository;
import com.example.cinemastars.repository.ReservationRepository;
import com.example.cinemastars.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository, UserRepository userRepository, ReservationRepository reservationRepository) {
        this.paymentRepository = paymentRepository;
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Payment save(String username, Long reservationId) {
        User user=userRepository.getById(username);
        Reservation reservation=reservationRepository.getById(reservationId);
        Payment payment=new Payment(reservation, user);
        return paymentRepository.save(payment);
    }
}
