package com.thanos.EmailSenderDemo.service;

import com.thanos.EmailSenderDemo.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender sender;

    public String sendMail(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getBody());

        sender.send(message);
        return "Email has been sent";
    }
}
