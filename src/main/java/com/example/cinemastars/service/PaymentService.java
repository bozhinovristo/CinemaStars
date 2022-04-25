package com.example.cinemastars.service;

import com.example.cinemastars.model.Payment;
import com.example.cinemastars.model.Reservation;

public interface PaymentService {
    public Payment save(String username, Long reservationId, String name, String surname, String cardNumber,
                        String cardExpiration, Integer securityCode);
    public Payment findByReservation(Reservation reservation);
    public void delete(Payment payment);
}
