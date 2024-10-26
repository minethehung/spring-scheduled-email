package com.hungmine.scheduled_mail_sender.controller;

import com.hungmine.scheduled_mail_sender.model.User;
import com.hungmine.scheduled_mail_sender.repository.UserRepository;
import com.hungmine.scheduled_mail_sender.service.MailService;
import com.hungmine.scheduled_mail_sender.service.ScheduledService;
import lombok.RequiredArgsConstructor;
import org.quartz.SchedulerException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final MailService mailService;
    private final ScheduledService scheduledService;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/send-email")
    public void sendEmail() {
        mailService.sendForAllUser();
    }

    @GetMapping("/schedule")
    public void sendSchedule(@RequestParam String exp) throws SchedulerException {
        scheduledService.schedule(exp);
    }
}
