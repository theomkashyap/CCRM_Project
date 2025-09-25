package edu.ccrm.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private String regNo;
    private List<Enrollment> enrolledCourses;
    private StatusUpdater statusUpdater; // Field for the inner class

    public Student(int id, String fullName, String email, LocalDate dateOfBirth, String regNo) {
        super(id, fullName, email, dateOfBirth);
        this.regNo = regNo;
        this.enrolledCourses = new ArrayList<>();
        this.statusUpdater = new StatusUpdater(); // Instantiate the inner class
    }

    // Inner class to manage student status
    public class StatusUpdater {
        private String currentStatus = "Active";

        public String getStatus() {
            return this.currentStatus;
        }

        public void deactivate() {
            this.currentStatus = "Inactive";
            System.out.println("Student " + Student.this.fullName + " has been deactivated.");
        }

        public void activate() {
            this.currentStatus = "Active";
        }
    }
    
    public StatusUpdater getStatusUpdater() {
        return this.statusUpdater;
    }

    @Override
    public String getProfileDetails() {
        return String.format("Student Profile:\n  ID: %d\n  Reg No: %s\n  Name: %s\n  Email: %s\n  Status: %s",
                id, regNo, fullName, email, statusUpdater.getStatus());
    }

    // --- Getters and Setters ---
    public String getRegNo() { return regNo; }
    public List<Enrollment> getEnrolledCourses() { return enrolledCourses; }
    public void addEnrollment(Enrollment enrollment) { this.enrolledCourses.add(enrollment); }
}