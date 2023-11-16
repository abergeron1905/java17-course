package com.pluralsight.courseinfo.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CourseTest {
    private static Stream<Arguments> argsProviderFactory() {
        return Stream.of(
                Arguments.of("", "Java17", "fake Url"),
                Arguments.of(null, "Java 15", "java 15 url"),
                Arguments.of("id Java8", "", "fake Url"),
                Arguments.of("id Java8", null, "java 8 url"),
                Arguments.of("id Java9", "Formation java 9", null),
                Arguments.of("id Java9", "Formation java 9", "")
        );
    }
    
    @Test
    void givenACourseWhenAllFieldsAreNotNullOrBlankThenTheCourseIsCreatedSuccessfully(){
        String id = "25E";
        String name = "Java Best Practices";
        String url =  "A fake Url";
        Course course = new Course(id, name, 25, url);

        assertTrue(course.id().equals(id));
        assertTrue(course.name().equals(name));
        assertTrue(course.url().equals(url));
     

    }

    @ParameterizedTest
    @MethodSource("argsProviderFactory")

    void whenACourseFieldIsNullorEmptyThenAnExceptionIsThrown(String id, String name, String url) {
       
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
           new Course(id, name, 175, url);
        });
      
        Assertions.assertEquals("No value present", thrown.getMessage());
    }
    
}
