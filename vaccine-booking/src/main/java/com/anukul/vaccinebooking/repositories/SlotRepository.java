package com.anukul.vaccinebooking.repositories;

import com.anukul.vaccinebooking.models.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Integer> {

}
