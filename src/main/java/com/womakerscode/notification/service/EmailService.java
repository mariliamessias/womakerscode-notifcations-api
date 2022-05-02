package com.womakerscode.notification.service;

import com.womakerscode.notification.model.SendEmaillMessage;

public interface EmailService {
    void send(SendEmaillMessage emailRequest);
}
