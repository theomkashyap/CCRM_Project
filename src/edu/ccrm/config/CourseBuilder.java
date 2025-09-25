package edu.ccrm.config;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.School;
import edu.ccrm.domain.Semester;

public class CourseBuilder {
    private String code;
    private String title;
    private int credits;
    private School school; // Changed from String
    private Semester semester;

    public CourseBuilder withCode(String code) {
        this.code = code;
        return this;
    }

    public CourseBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public CourseBuilder withCredits(int credits) {
        this.credits = credits;
        return this;
    }

    public CourseBuilder withSchool(School school) { // Changed parameter type
        this.school = school;
        return this;
    }

    public CourseBuilder withSemester(Semester semester) {
        this.semester = semester;
        return this;
    }

    public Course build() {
        return new Course(code, title, credits, school, semester);
    }
}