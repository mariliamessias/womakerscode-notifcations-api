package com.womakerscode.notification.service.impl;

import com.womakerscode.notification.model.SendEmaillMessage;
import com.womakerscode.notification.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void send(SendEmaillMessage message) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(message.getEmail());

        msg.setSubject("Sua inscrição no Evento foi registrada com sucesso!");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);
    }
}
