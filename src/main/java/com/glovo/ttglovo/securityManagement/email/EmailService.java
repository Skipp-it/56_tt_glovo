package com.glovo.ttglovo.securityManagement.email;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
@AllArgsConstructor
public class EmailService implements EmailSender {

    //used for logging when sending email
    // poate fi inlocuit cu Lombok @Slf4j
    private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    private final JavaMailSender mailSender;

    @Override
    @Async
    public void send(String to, String email) {

        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            //true pentru ca mesajul sa fie sub forma HTML
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Confirm your email client");
            mailSender.send(mimeMessage);

        } catch (MessagingException e) {
            //logger used here for logging the errors and do not sending them to user
            LOGGER.error("failed to send email", e);
            throw new IllegalStateException("failed to send email");
        }
    }
}
