package com.anukul.vaccinebooking.controllers;

import com.anukul.vaccinebooking.models.Booking;
import com.anukul.vaccinebooking.models.User;
import com.anukul.vaccinebooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/get/{userId}")
    public User getUserById(@PathVariable int userId) throws Exception {
        return userService.getUserById(userId);
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user){
        userService.addNewUser(user);
    }

    @GetMapping("/getAllBookingsForUser/{userId}")
    public List<Booking> getAllBookingsForUser(@PathVariable int userId) throws Exception {
        return userService.getAllBookingsForUser(userId);
    }
}
