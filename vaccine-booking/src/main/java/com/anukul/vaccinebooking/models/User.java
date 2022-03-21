package com.anukul.vaccinebooking.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue
    private Integer Id;

    @NotNull
    private String name;

    @NotNull
    private String address;

    @Column(unique = true, nullable = false)
    private String govtID;

    @NotNull
    private Date DOB;

    @Column(length = 10,unique = true, nullable = false)
    private String phoneNo;

    @Transient
    private int Age;

}
