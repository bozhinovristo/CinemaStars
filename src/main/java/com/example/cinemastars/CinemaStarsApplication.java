package com.example.cinemastars;

import com.example.cinemastars.service.EmailSenderService;
import com.example.cinemastars.service.impl.EmailSenderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.mail.MessagingException;

@SpringBootApplication
public class CinemaStarsApplication {

    @Autowired
    private EmailSenderService senderService;

    public static void main(String[] args) {
        SpringApplication.run(CinemaStarsApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendMail() throws MessagingException {
//        senderService.sendEmail("anageorgieska@gmail.com",
//                "Sample Subject", "This is the body of the email");

//        senderService.sendEmailWithAttachment("bozhinovristo@gmail.com",
//                "This is email body with attachment",
//                "this is the subject",
//                "C:\\Users\\bozhi\\Downloads\\RasporedJunska2021.pdf");
    }
}
