package com.anukul.vaccinebooking.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name="Slots")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "slotId")
public class Slot {

    @Id
    @GeneratedValue
    private Integer slotId;

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
