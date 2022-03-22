package com.anukul.vaccinebooking.service;

import com.anukul.vaccinebooking.models.Slot;
import com.anukul.vaccinebooking.models.User;
import com.anukul.vaccinebooking.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    SlotService slotService;

    @Autowired
    UserService userService;

    //checks:
    //- slot and user are valid
    //-slot is in future
    //-age limit
    //-doses available
    //-user history
        //--pending appointment
        //--if already vaccinated
        //--same vaccine
        //--days difference
    public String bookSlotForUser(int slotId, int userId) throws Exception {

        Slot slot= slotService.getSlotById(slotId);
        User user= userService.getUserById(userId);

        if(checkIfSlotExpired(slot)){
            throw new IllegalArgumentException("Slot is Expired");
        }

        return "";
    }

    private boolean checkIfSlotExpired(Slot slot) {
        LocalDate currentDate= LocalDate.now();

        if (slot.getDate().toLocalDate().compareTo(currentDate)<0){
            return true;
        }
        return false;
    }
}
