package com.example.cinemastars.events;
import com.example.cinemastars.model.Reservation;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CancellationEvent extends ApplicationEvent {

    public Reservation reservation;

    public CancellationEvent(Reservation source) {
        super(source);
        this.reservation=source;
    }
}
