package com.anukul.vaccinebooking.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="Locations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Location {

    @Id
    @GeneratedValue
    private Integer locationId;

    @NotNull
    private String name;

    @NotNull
    private String address;

    @NotNull
    @Min(100000)
    @Max(999999)
    private Integer pincode;

    @JsonIgnore
              //mappedBy will prevent hibernate from creating a separate location_slot table
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)  //"location" is attribute name of Location in slot class
    private List<Slot> slots;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Agency agency;


}
