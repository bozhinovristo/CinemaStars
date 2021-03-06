package com.example.cinemastars.web;

import com.example.cinemastars.model.Payment;
import com.example.cinemastars.model.Projection;
import com.example.cinemastars.model.Reservation;
import com.example.cinemastars.model.User;
import com.example.cinemastars.service.PaymentService;
import com.example.cinemastars.service.ReservationService;
import com.example.cinemastars.service.SeatService;
import com.example.cinemastars.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    private final ReservationService reservationService;
    private final PaymentService paymentService;
    private final SeatService seatService;
    private final UserService userService;

    public PaymentController(ReservationService reservationService, PaymentService paymentService, SeatService seatService, UserService userService) {
        this.reservationService = reservationService;
        this.paymentService = paymentService;
        this.seatService = seatService;
        this.userService = userService;
    }

    @PostMapping("")
    public String reserve(HttpSession session, Model model, @RequestParam String name,
                          @RequestParam String surname, @RequestParam String cardNumber,
                          @RequestParam String cardExpiration, @RequestParam Integer securityCode,
                          Authentication authentication)
    {
        List<Integer> seats= (List<Integer>) session.getAttribute("seats");
        Projection projection=(Projection) session.getAttribute("projection");
        User user = (User) authentication.getPrincipal();
        Reservation reservation=reservationService.save(user.getUsername(), seats, projection.getId(), seats.size()* projection.getPrice());
        reservation.getSeats().forEach(s-> {
            s.setReserved(true);
            seatService.save(s);
        });

        Payment payment=paymentService.save(reservation.getUser().getUsername(), reservation.getId(), name, surname,
                cardNumber, cardExpiration,securityCode);

        return "redirect:/movies";
    }
}
