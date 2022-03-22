package com.anukul.vaccinebooking.service;

import com.anukul.vaccinebooking.models.User;
import com.anukul.vaccinebooking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int userId) throws Exception {
        return userRepository.findById(userId)
                .orElseThrow(()-> new Exception("User not found"));
    }

    public void addNewUser(User user) {
        userRepository.save(user);
    }
}
