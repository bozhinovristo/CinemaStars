package com.example.cinemastars.events;

import com.example.cinemastars.model.Reservation;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class ReservationEvent extends ApplicationEvent {

    public Reservation reservation;

    public ReservationEvent(Reservation source) {
        super(source);
        this.reservation=source;
    }
}
