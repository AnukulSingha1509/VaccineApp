package com.anukul.vaccinebooking.service;

import com.anukul.vaccinebooking.models.Location;
import com.anukul.vaccinebooking.models.Slot;
import com.anukul.vaccinebooking.repositories.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlotService {

    @Autowired
    SlotRepository slotRepository;

    public Slot getSlotById(int slotId) throws Exception {
        return slotRepository.findById(slotId)
                .orElseThrow(()-> new Exception("Slot not found"));
    }

    public List<Slot> getAllSlots() {

        return slotRepository.findAll();
    }

    public void addSlot(Slot slot, int locationId) throws Exception {

//        Location thisLocation= locationService.getLocationById(locationId);
//        slot.setLocation(thisLocation);
//        slotRepository.save(slot);
    }
}
