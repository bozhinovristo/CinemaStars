package com.example.cinemastars.listeners;

import com.example.cinemastars.events.ReservationEvent;
import com.example.cinemastars.model.Reservation;
import com.example.cinemastars.service.EmailSenderService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.stream.Collectors;

@Component
public class ReservationListener {
    private final EmailSenderService senderService;

    public ReservationListener(EmailSenderService senderService) {
        this.senderService = senderService;
    }

    @EventListener()
    public void sendMail(ReservationEvent event) throws MessagingException {
        Reservation reservation=event.reservation;
        StringBuilder stringBuilder=new StringBuilder();
        String reservationInfo=stringBuilder
                .append("Name: ").append(reservation.getProjection().getMovie().getName()).append("\n")
                .append("Date and time: ").append(reservation.getProjection().getTimestamp()).append("\n")
                .append("Hall: ").append(reservation.getProjection().getHall().getName()).append("\n")
                .append("Price: ").append(reservation.getPrice()).append("\n")
                .append("Seats: ").append(reservation.getSeats().stream().map(s->s.getSeatNumber().toString()).collect(Collectors.joining(" ")))
                .toString();
        senderService.sendEmail(reservation.getUser().getUsername(),
                "Reservation", reservationInfo);

//        senderService.sendEmailWithAttachment("bozhinovristo@gmail.com",
//                "This is email body with attachment",
//                "this is the subject",
//                "C:\\Users\\bozhi\\Downloads\\RasporedJunska2021.pdf");
    }
}
