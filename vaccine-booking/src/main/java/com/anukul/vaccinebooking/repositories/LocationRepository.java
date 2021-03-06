package com.anukul.vaccinebooking.repositories;

import com.anukul.vaccinebooking.models.Location;
import com.anukul.vaccinebooking.models.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}
