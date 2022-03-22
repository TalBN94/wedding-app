package com.songvoting.vote.repository;

import com.songvoting.vote.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findFirstByPhoneNumber(String phoneNumber);
}