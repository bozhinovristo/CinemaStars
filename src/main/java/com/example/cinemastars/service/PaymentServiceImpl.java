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
    public Payment save(String username, Long reservationId, String name, String surname, String cardNumber,
                        String cardExpiration, Integer securityCode) {
        User user=userRepository.getById(username);
        Reservation reservation=reservationRepository.getById(reservationId);
        Payment payment=new Payment(reservation, user, name, surname, cardNumber, cardExpiration, securityCode);
        return paymentRepository.save(payment);
    }

    @Override
    public Payment findByReservation(Reservation reservation) {
        return paymentRepository.findByReservation(reservation).get();
    }

    @Override
    public void delete(Payment payment) {
        paymentRepository.delete(payment);
    }
}
