package edu.ccrm.service;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.School;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class CourseService {
    private final List<Course> courses = new CopyOnWriteArrayList<>();

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(courses);
    }

    public Optional<Course> findCourseByCode(String code) {
        return courses.stream()
            .filter(c -> c.getCode().equalsIgnoreCase(code))
            .findFirst();
    }
    
    // New method for searching using Stream API filter
    public List<Course> findCoursesBySchool(School school) {
        return courses.stream()
            .filter(course -> course.getSchool() == school)
            .collect(Collectors.toList());
    }
}