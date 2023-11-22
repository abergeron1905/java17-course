package com.pluralsight.cli.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PluralsightCourseTest {

    @ParameterizedTest
    @CsvSource(textBlock =  """
        00:05:37, 5 
        01:08:54.9613330, 68
        00:00:00, 0
        """)
    void testDurationInMinutes(String duration, long expected) {
        PluralsightCourse course = new PluralsightCourse("id", "Test course", duration, "url", false);

        assertEquals(expected, course.durationInMinutes());
    }
    


}
