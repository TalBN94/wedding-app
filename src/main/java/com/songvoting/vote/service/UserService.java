package com.songvoting.vote.service;

import com.songvoting.vote.domain.entities.User;
import com.songvoting.vote.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public boolean register(String phoneNumber) {
        Optional<User> user = userRepository.findFirstByPhoneNumber(phoneNumber);
        if (user.isPresent()) {
            return false;
        } else {
            userRepository.save(User.builder().phoneNumber(phoneNumber).build());
            return true;
        }
    }
}
