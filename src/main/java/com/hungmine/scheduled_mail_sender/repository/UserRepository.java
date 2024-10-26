package com.hungmine.scheduled_mail_sender.repository;

import com.hungmine.scheduled_mail_sender.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}