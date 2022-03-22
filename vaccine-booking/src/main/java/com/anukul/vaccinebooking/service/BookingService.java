package com.anukul.vaccinebooking.service;

import com.anukul.vaccinebooking.models.*;
import com.anukul.vaccinebooking.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.SysexMessage;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

        if(ageNotInLimit(user,slot)){
            throw new IllegalArgumentException("User age not in slot age limit");
        }

        if(slot.getDosesAvailable()<1){
            throw new IllegalArgumentException("No doses available in this slot");
        }

        List<Booking> bookingsForUser= userService.getAllBookingsForUser(user.getId());
        List<Booking> completedBookings= new ArrayList<>();
        for(Booking curr: bookingsForUser){
            if(curr.getCompletionStatus().equals(CompletionStatus.PENDING)){
                throw new IllegalArgumentException("Booking for user is already pending");
            }
            if(curr.getCompletionStatus().equals(CompletionStatus.COMPLETED)){
                completedBookings.add(curr);
            }
        }

        if(completedBookings.size()>0 && VaccineIsNotSame(slot,completedBookings)){
            throw new IllegalArgumentException("Please book for the same vaccine as before");
        }

        if(IsAlreadyVaccinated(user,slot,completedBookings)){
            throw new IllegalArgumentException("User is already fully vaccinated");
        }

        if(completedBookings.size()>0 && MinDaysGapNotCompleted(completedBookings,slot)){
            throw new IllegalArgumentException("User has not completed minimum number of days gap");
        }

        slot.setDosesAvailable(slot.getDosesAvailable()-1);
        slotService.addOrUpdateSlot(slot);

        Booking booking= new Booking();
        booking.setSlot(slot);
        booking.setUser(user);
        booking.setCompletionStatus(CompletionStatus.PENDING);
        booking.setReferenceId(UUID.randomUUID().toString());

        bookingRepository.save(booking);


        return "Booking successful with ref id: "+booking.getReferenceId();
    }



    private boolean MinDaysGapNotCompleted(List<Booking> completedBookings, Slot slot) {
        if(slot.getVaccine()==Vaccine.SPUTNIK){
            return false;
        }else{
            Date lastVaccinatedDate= completedBookings.get(completedBookings.size()-1).getSlot().getDate();
            if(slot.getDate().toLocalDate().compareTo(lastVaccinatedDate.toLocalDate())< slot.getVaccine().getDaysGap()){
                return true;
            }
        }
        return false;
    }

    private boolean VaccineIsNotSame(Slot slot, List<Booking> completedBookings) {
        Vaccine vaccine= completedBookings.get(0).getSlot().getVaccine();
        if(!slot.getVaccine().equals(vaccine)){
            return true;
        }

        return false;
    }

    private boolean IsAlreadyVaccinated(User user, Slot slot, List<Booking> completedBookings) {
        if(completedBookings.size() < slot.getVaccine().getNumDoses()){
            return false;
        }
        return true;
    }


    private boolean ageNotInLimit(User user, Slot slot) {
        if(user.getAge()> slot.getAgeLimit().getMinAge()){
            if(slot.getAgeLimit().getMaxAge()!=null && user.getAge() > slot.getAgeLimit().getMaxAge()){
                return true;
            }
            return false;
        }
        return true;
    }

    private boolean checkIfSlotExpired(Slot slot) {
        LocalDate currentDate= LocalDate.now();

        if (slot.getDate().toLocalDate().compareTo(currentDate)<0){
            return true;
        }
        return false;
    }


    private Booking getBooking(int bookingId){
        return bookingRepository.getById(bookingId);
    }

    public String completeBooking(int userId){

        try{
            Booking pendingBooking= getBooking((bookingRepository.getPendingBooking(userId)));

            pendingBooking.setCompletionStatus(CompletionStatus.COMPLETED);
            bookingRepository.save(pendingBooking);

            return "Booking : "+pendingBooking.getReferenceId()+" completed";

        }catch(NullPointerException e){
            return "No pending booking found for user";
        }

    }

    public String cancelBooking(int userId) throws Exception {

        try{
            Booking pendingBooking= getBooking(bookingRepository.getPendingBooking(userId));
            Slot slot= pendingBooking.getSlot();
            slot.setDosesAvailable(slot.getDosesAvailable()+1);
            slotService.addOrUpdateSlot(slot);

            pendingBooking.setCompletionStatus(CompletionStatus.CANCELLED);
            bookingRepository.save(pendingBooking);

            return "Booking with booking id: "+pendingBooking.getReferenceId()+"+ is cancelled";

        }catch (NullPointerException e){
            return "No pending booking found for user.";
        }

    }
}
