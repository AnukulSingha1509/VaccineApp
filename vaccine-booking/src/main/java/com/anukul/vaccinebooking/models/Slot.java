package com.anukul.vaccinebooking.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="Slots")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Slot {

    @Id
    @GeneratedValue
    private Integer slotId;

    @NotNull
    @ManyToOne
    @JoinColumn(name="location_id")
    private Location location;

    @NotNull
    private Date date;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Vaccine vaccine;

    @Enumerated(EnumType.STRING)
    @NotNull
    private AgeLimit ageLimit;

    @NotNull
    @Min(1)
    private Integer dosesAvailable;

}
