package com.hungmine.scheduled_mail_sender.service;

import com.hungmine.scheduled_mail_sender.model.User;
import com.hungmine.scheduled_mail_sender.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailService {
    private final JavaMailSender mailSender;
    private final UserRepository userRepository;

    public void sendForAllUser () {
        List<User> users = userRepository.findAll();
        try (ExecutorService executorService = Executors.newFixedThreadPool(4)) {
            for (User user : users) {
                executorService.submit(() -> sendForUser(user.getEmail()));
            }
        }

    }
    public void sendForUser (String to) {
        log.info("Sending email for user {}", to);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Scheduled Mail Sender at: " + LocalDateTime.now());
        message.setText("Hello from minethehung!. This is an auto sent email");
        message.setFrom("hung.mai.150302@gmail.com");
        mailSender.send(message);
    }
}
