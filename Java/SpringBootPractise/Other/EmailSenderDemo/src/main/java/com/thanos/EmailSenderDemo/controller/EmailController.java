package com.thanos.EmailSenderDemo.controller;

import com.thanos.EmailSenderDemo.model.Email;
import com.thanos.EmailSenderDemo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email/send")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<String> sendMail(@RequestBody Email email) {
        return ResponseEntity.ok().body(emailService.sendMail(email));
    }
}
