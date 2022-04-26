package com.example.cinemastars.service;

import javax.mail.MessagingException;

public interface EmailSenderService {

    void sendEmail(String toEmail, String subject, String body);

    void sendEmailWithAttachment(String toEmail, String body, String subject, String attachment) throws MessagingException;

}
