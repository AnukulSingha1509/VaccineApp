package com.anukul.vaccinebooking.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Booking {

    private Integer bookingId;

    private Integer referenceId;

    private User user;

    private Slot slot;
}
