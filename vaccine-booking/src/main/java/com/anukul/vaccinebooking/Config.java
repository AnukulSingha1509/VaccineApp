package com.anukul.vaccinebooking;

import com.anukul.vaccinebooking.models.Agency;
import com.anukul.vaccinebooking.models.Location;
import com.anukul.vaccinebooking.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//@Component
public class Config {

    @Autowired
    private LocationRepository locationRepository;


   // @Bean
    CommandLineRunner commandLineRunner(){
        return args->{

            Location locObj= new Location();

            Location locObj2= new Location();

            locObj.setName("Location 1");
            locObj.setAgency(Agency.GOVERNMENT);
            locObj.setAddress("Some Address");
            locObj.setPincode(110087);

            locObj2.setName("Location 2");
            locObj2.setAgency(Agency.PRIVATE);
            locObj2.setAddress("Some Address 2");
            locObj2.setPincode(110011);

            locationRepository.save(locObj);
            locationRepository.save(locObj2);


        };
    }

}
