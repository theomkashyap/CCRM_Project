package edu.ccrm.domain;

import java.time.LocalDate;

public class Enrollment {
    private static int nextId = 1;
    private final int enrollmentId;
    private final Student student;
    private final Course course;
    private final LocalDate enrollmentDate;
    private Grade grade;

    public Enrollment(Student student, Course course) {
        this.enrollmentId = nextId++;
        this.student = student;
        this.course = course;
        this.enrollmentDate = LocalDate.now();
        this.grade = Grade.N; // Default to Not Graded
    }

    // --- Getters and Setters ---
    public int getEnrollmentId() { return enrollmentId; }
    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public Grade getGrade() { return grade; }
    public void setGrade(Grade grade) { this.grade = grade; }
    
    @Override
    public String toString() {
        return String.format("Enrollment[ID=%d, Student=%s, Course=%s, Grade=%s]",
            enrollmentId, student.getFullName(), course.getCode(), grade);
    }
}