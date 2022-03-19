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
public class Users {

    @Id
    @GeneratedValue
    private Integer Id;

    @NotNull
    private String name;

    @NotNull
    private String address;

    @NotNull
    private Date DOB;

    @NotNull
    @Column(length = 10)
    private String phoneNo;

}
