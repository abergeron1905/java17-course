package com.pluralsight.cli.service;

import java.util.List;

import com.pluralsight.courseinfo.domain.Course;
import com.pluralsight.courseinfo.repository.CourseRepository;


public class CourseStorageService {
    private static final String PS_BASE_STRING = "https://app.pluralsight.com";
    private final CourseRepository courseRepository;

    public CourseStorageService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void storePlurialsightCourses(List<PluralsightCourse> psCourses){
        for(PluralsightCourse psCourse:psCourses){
            Course course = new Course(psCourse.id(), psCourse.title(), psCourse.durationInMinutes(), PS_BASE_STRING + psCourse.contactUrl());
           
            courseRepository.saveCourse(course);
        }
    }

 
}
