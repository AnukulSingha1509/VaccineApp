package com.anukul.vaccinebooking.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

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
    @Getter(AccessLevel.NONE)
    private int Age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    public int getAge() {
        return Period.between(this.DOB.toLocalDate(), LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        Age = age;
    }
}
