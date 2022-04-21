package com.example.cinemastars.service;

import com.example.cinemastars.model.Payment;

public interface PaymentService {
    public Payment save(String username, Long reservationId, String name, String surname, String cardNumber,
                        String cardExpiration, Integer securityCode);
}
