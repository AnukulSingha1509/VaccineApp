package com.anukul.vaccinebooking.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Booking {

    @Id
    @GeneratedValue
    private Integer bookingId;

    @Column(unique = true, nullable = false)
    private Integer referenceId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name= "slot_id")
    private Slot slot;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CompletionStatus completionStatus;
}
