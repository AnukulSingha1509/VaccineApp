package com.anukul.vaccinebooking;

import com.anukul.vaccinebooking.models.*;
import com.anukul.vaccinebooking.repositories.LocationRepository;
import com.anukul.vaccinebooking.repositories.SlotRepository;
import com.anukul.vaccinebooking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class Config {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private SlotRepository slotRepository;


    @Bean
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

            Slot slotObj1= new Slot();
            Slot slotObj2= new Slot();

            slotObj1.setLocation(locObj);
            slotObj1.setAgeLimit(AgeLimit.AGE18TO45);
            slotObj1.setDate(Date.valueOf("2022-03-24"));
            slotObj1.setVaccine(Vaccine.COVISHIELD);
            slotObj1.setDosesAvailable(100);

            slotObj2.setLocation(locObj2);
            slotObj2.setAgeLimit(AgeLimit.AGE60TOABOVE);
            slotObj2.setDate(Date.valueOf("2022-03-28"));
            slotObj2.setVaccine(Vaccine.SPUTNIK);
            slotObj2.setDosesAvailable(57);

            slotRepository.save(slotObj1);
            slotRepository.save(slotObj2);

            User userObj1= new User();
            User userObj2= new User();

            userObj1.setName("Anukul Singhal");
            userObj1.setDOB(Date.valueOf("1996-09-15"));
            userObj1.setGovtID("abcd00234");
            userObj1.setAddress("100/A1, Delhi");
            userObj1.setPhoneNo("9999999991");

            userObj2.setName("Abc Xyz");
            userObj2.setDOB(Date.valueOf("2004-01-23"));
            userObj2.setGovtID("LMNOP34-89");
            userObj2.setAddress("100, ABC Vihar, Delhi");
            userObj2.setPhoneNo("9999999922");

            userRepository.save(userObj1);
            userRepository.save(userObj2);


        };
    }

}
