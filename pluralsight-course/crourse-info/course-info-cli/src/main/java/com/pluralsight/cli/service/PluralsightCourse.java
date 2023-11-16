package com.pluralsight.cli.service;

import java.time.Duration;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record PluralsightCourse(String id, String title, String duration, String contactUrl, boolean isRetired) {

    public long durationInMinutes() {
        return Duration.between(
            LocalTime.MIN, 
            LocalTime.parse(duration())
        ).toMinutes();
        
    }
    

}
