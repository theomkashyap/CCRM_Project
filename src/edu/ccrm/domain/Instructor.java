package edu.ccrm.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Instructor extends Person {
    private String employeeId;
    private List<Course> assignedCourses;

    public Instructor(int id, String fullName, String email, LocalDate dateOfBirth, String employeeId) {
        super(id, fullName, email, dateOfBirth);
        this.employeeId = employeeId;
        this.assignedCourses = new ArrayList<>();
    }

    @Override
    public String getProfileDetails() {
        return String.format("Instructor Profile:\n  ID: %d\n  Employee ID: %s\n  Name: %s",
                id, employeeId, fullName);
    }
}