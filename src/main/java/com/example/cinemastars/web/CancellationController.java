package com.example.cinemastars.web;

import com.example.cinemastars.events.CancellationEvent;
import com.example.cinemastars.model.Payment;
import com.example.cinemastars.model.Reservation;
import com.example.cinemastars.model.User;
import com.example.cinemastars.service.PaymentService;
import com.example.cinemastars.service.ReservationService;
import com.example.cinemastars.service.SeatService;
import com.example.cinemastars.service.UserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cancellation")
public class CancellationController {

    private final UserService userService;
    private final ReservationService reservationService;
    private final SeatService seatService;
    private final PaymentService paymentService;
    private final ApplicationEventPublisher applicationEventPublisher;

    public CancellationController(UserService userService, ReservationService reservationService, SeatService seatService, PaymentService paymentService, ApplicationEventPublisher applicationEventPublisher) {
        this.userService = userService;
        this.reservationService = reservationService;
        this.seatService = seatService;
        this.paymentService = paymentService;
        this.applicationEventPublisher = applicationEventPublisher;
    }


    @GetMapping()
    public String cancel(Model model, Authentication authentication)
    {

        User user = (User) authentication.getPrincipal();

        List<Reservation> reservations=reservationService.findByUser(user);

        model.addAttribute("reservations", reservations);

        return "cancellation";
    }
    @PostMapping("/{id}")
    public String cancelRes(@PathVariable Long id)
    {

        Reservation reservation=reservationService.findById(id);

        this.applicationEventPublisher.publishEvent(new CancellationEvent(reservation));

        reservation.getSeats().forEach(s-> {
            s.setReserved(false);
            seatService.save(s);
        });

        Payment payment=paymentService.findByReservation(reservation);

        paymentService.delete(payment);
        reservationService.delete(reservation);

        return "redirect:/cancellation";
    }
}
