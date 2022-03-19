package com.anukul.vaccinebooking.controllers;

import com.anukul.vaccinebooking.models.Slot;
import com.anukul.vaccinebooking.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/slot")
public class SlotController {

    @Autowired
    SlotService slotService;

    @GetMapping("/{slotId}")
    public Slot getSlotById(@PathVariable int slotId) throws Exception{

        return slotService.getSlotById(slotId);

    }

    @GetMapping("/all")
    public List<Slot> getAllSlots(){
        return slotService.getAllSlots();
    }

    @PostMapping("/add/{location_id}")
    public void addSlot(@RequestBody Slot slot, @PathVariable int location_id) throws Exception {
        slotService.addSlot(slot, location_id);
    }

}
