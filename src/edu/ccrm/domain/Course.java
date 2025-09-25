package edu.ccrm.domain;

public class Course {
    private String code;
    private String title;
    private int credits;
    private School school; // Changed from String
    private Semester semester;

    public Course(String code, String title, int credits, School school, Semester semester) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.school = school; // Changed from String
        this.semester = semester;
    }

    // --- Getters ---
    public String getCode() { return code; }
    public String getTitle() { return title; }
    public int getCredits() { return credits; }
    public School getSchool() { return school; } // Changed return type
    public Semester getSemester() { return semester; }

    @Override
    public String toString() {
        return String.format("Course[Code=%s, Title='%s', Credits=%d, School=%s]", code, title, credits, school);
    }
}