package com.anukul.vaccinebooking.controllers;

import com.anukul.vaccinebooking.models.Location;
import com.anukul.vaccinebooking.models.Slot;
import com.anukul.vaccinebooking.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    LocationService locationService;

    @GetMapping("/{locationId}")
    public Location getLocationById(@PathVariable int locationId) throws Exception {
        return locationService.getLocationById(locationId);
    }

    @GetMapping("/all")
    public List<Location> getAllLocations(){

        return locationService.getAllLocations();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public void addLocation(@RequestBody Location location){
        locationService.save(location);
    }

    @GetMapping("/getSlots/{locationId}")
    public List<Slot> getAllSlots(@PathVariable int locationId){
        return locationService.getAllSlots(locationId);
    }


}
