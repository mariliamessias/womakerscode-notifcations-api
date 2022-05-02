package com.womakerscode.notification.listeners;

import com.womakerscode.notification.configs.MQConfig;
import com.womakerscode.notification.model.SendEmaillMessage;
import com.womakerscode.notification.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(SendEmaillMessage message){
        emailService.send(message);
    }

}
