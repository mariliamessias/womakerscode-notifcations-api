package com.womakerscode.notification.service.impl;

import com.womakerscode.notification.model.SendEmaillMessage;
import com.womakerscode.notification.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    private String userName;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;


    @Override
    public void send(SendEmaillMessage message) throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        Context context = new Context();
        context.setVariables(
                Map.of("name", message.getName(), "event", message.getEventName()));
        helper.setFrom(userName);
        helper.setTo(message.getEmail());
        helper.setSubject("Sua inscrição no evento foi registrada com sucesso!");
        String html = templateEngine.process("mailTemplate.html", context);
        helper.setText(html, true);

        javaMailSender.send(mimeMessage);
    }

}
