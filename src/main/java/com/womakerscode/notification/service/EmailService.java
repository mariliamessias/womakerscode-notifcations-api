package com.womakerscode.notification.service;

import com.womakerscode.notification.model.SendEmaillMessage;

import javax.mail.MessagingException;

public interface EmailService {
    void send(SendEmaillMessage emailRequest) throws MessagingException;
}
