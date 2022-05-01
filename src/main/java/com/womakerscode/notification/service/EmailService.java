package com.womakerscode.notification.service;

import com.womakerscode.notification.controller.request.EmailRequest;
import com.womakerscode.notification.controller.response.EmailResponse;

public interface EmailService {
    EmailResponse send(EmailRequest emailRequest);
}
