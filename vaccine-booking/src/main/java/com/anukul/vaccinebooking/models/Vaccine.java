package com.anukul.vaccinebooking.models;

import lombok.Getter;

@Getter
public enum Vaccine {

    COVISHIELD("covishield", 2, 30, 100.00 ),
    COVAXIN("covaxin", 2, 35, 150.00),
    SPUTNIK("sputnik", 1, null, 500.00);

    String name;
    Integer numDoses;
    Integer daysGap;
    Double cost;

    Vaccine(String name, Integer numDoses, Integer daysGap, Double cost) {
        this.name = name;
        this.numDoses = numDoses;
        this.daysGap = daysGap;
        this.cost = cost;
    }
}
