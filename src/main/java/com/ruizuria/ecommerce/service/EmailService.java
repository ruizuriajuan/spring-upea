package com.ruizuria.ecommerce.service;

import com.ruizuria.ecommerce.dto.EmailNotificationDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public String send(EmailNotificationDto dto) {
        if (dto.isHasTemplate()) {
            sendTemplate(dto);
        } else {
            sendPlainText(dto);
        }
        return "Your email has been sent successfully";
    }

    private void sendPlainText(EmailNotificationDto dto) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(dto.getTo());
        mailMessage.setSubject(dto.getSubject());
        mailMessage.setText(dto.getBody());
        javaMailSender.send(mailMessage);
    }

    //Para enviar en formato html
    private void sendTemplate(EmailNotificationDto dto) {
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mailMessage);
        try {
            helper.setTo(dto.getTo());
            helper.setSubject(dto.getSubject());
            helper.setText(dto.getBody(), true); //true es formato html
            javaMailSender.send(mailMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
