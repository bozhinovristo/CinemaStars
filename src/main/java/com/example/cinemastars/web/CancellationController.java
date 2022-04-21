package com.example.cinemastars.web;

import com.example.cinemastars.model.Reservation;
import com.example.cinemastars.model.User;
import com.example.cinemastars.service.ReservationService;
import com.example.cinemastars.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cancellation")
public class CancellationController {

    private final UserService userService;
    private final ReservationService reservationService;

    public CancellationController(UserService userService, ReservationService reservationService) {
        this.userService = userService;
        this.reservationService = reservationService;
    }


    @GetMapping()
    public String cancel(Model model)
    {

        String username="user0";
        User user= userService.findById(username);
        List<Reservation> reservations=reservationService.findByUser(user);

        model.addAttribute("reservations", reservations);

        return "cancellation";
    }
}
