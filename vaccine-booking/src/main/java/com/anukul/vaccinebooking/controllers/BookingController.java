package com.anukul.vaccinebooking.controllers;

import com.anukul.vaccinebooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("bookSlot/{slotId}/{userId}")
    public String bookSlotForUser(@PathVariable int slotId, @PathVariable int userId) throws Exception {
        return bookingService.bookSlotForUser(slotId, userId);
    }

}
