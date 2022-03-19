package com.anukul.vaccinebooking.models;

import lombok.Getter;

@Getter
public enum AgeLimit {

    AGE0TO18(0,18),
    AGE18TO45(18,45),
    AGE45TO60(45,60),
    AGE0TOABOVE(0, null),
    AGE60TOABOVE(60, null),
    AGE18TOABOVE(18, null),
    AGE45TOABOVE(45, null);

    Integer minAge;
    Integer maxAge;

    AgeLimit(Integer minAge, Integer maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }
}
