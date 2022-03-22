package com.anukul.vaccinebooking.repositories;

import com.anukul.vaccinebooking.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Query(value= "SELECT booking_id FROM BOOKINGS WHERE user_id= ?1 AND completion_status= 'PENDING' ",nativeQuery = true)
    Integer getPendingBooking(int userId);
}
