package com.pluralsight.cli;

import static java.util.function.Predicate.not;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pluralsight.cli.service.CourseRetrieverService;
import com.pluralsight.cli.service.PluralsightCourse;

public class CourseRetriever {
    private static final Logger LOG = LoggerFactory.getLogger(CourseRetriever.class);

    public static void main(String[] args) {

        LOG.info("CourseRetriever started");
        if (args.length == 0) {
            LOG.warn("Please provide an author name as first argument");
        }

        try {
            retrieveCourses(args[0]);
        } catch (Exception e) {
            LOG.error("Unexpected error", e);
            e.printStackTrace();
        }

    }

    private static void retrieveCourses(String authorName) {
        LOG.info("Retrieving courses for author {}" + authorName);
        CourseRetrieverService courseRetrieverservice = new CourseRetrieverService();

        List<PluralsightCourse> coursesToStore = courseRetrieverservice.getCoursesFor(authorName)
                .stream()
                .filter(course -> !(course.isRetired()))
                .toList();

        coursesToStore = coursesToStore
                .stream()
                .filter(not(PluralsightCourse::isRetired))
                .toList();

        LOG.info("Retrieved the following the following {} courses {}", coursesToStore.size(),
                coursesToStore.toString());
    }
}
