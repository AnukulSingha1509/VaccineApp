package com.anukul.vaccinebooking.controllers;

import com.anukul.vaccinebooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/{slotId}/{userId}")
    public String bookSlotForUser(@RequestParam int slotId, @RequestParam int userId) throws Exception {
        return bookingService.bookSlotForUser(slotId, userId);
    }

}
