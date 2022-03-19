package com.anukul.vaccinebooking.service;

import com.anukul.vaccinebooking.models.Location;
import com.anukul.vaccinebooking.models.Slot;
import com.anukul.vaccinebooking.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;


    public Location getLocationById(int locationId) throws Exception {
        // TODO Auto-generated method stub
        return locationRepository.findById(locationId)
                .orElseThrow(()-> new Exception("Location not found"));
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public void save(Location location) {
        locationRepository.save(location);
    }

    public List<Slot> getAllSlots(int locationId) {
        //return new ArrayList<Slot>();
        return locationRepository.getAllSlots(locationId);
    }
}











