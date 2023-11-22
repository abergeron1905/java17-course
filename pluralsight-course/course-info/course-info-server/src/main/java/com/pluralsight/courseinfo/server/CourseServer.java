package com.pluralsight.courseinfo.server;

import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pluralsight.courseinfo.repository.CourseRepository;

public class CourseServer {

    private static final Logger LOG = LoggerFactory.getLogger(CourseServer.class);
    private static final String BASE_URI = "http://localhost:8080/";

    CourseRepository courseRepository = CourseRepository.openCourseRepository("./courses.db");
    ResourceConfig config = new ResourceConfig().register(new CourseResource((courseRepository)));
         
    
    GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), config);
    
}
