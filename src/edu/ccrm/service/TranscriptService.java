package edu.ccrm.service;

import edu.ccrm.domain.Student;
import edu.ccrm.domain.Grade;

public class TranscriptService {

    /**
     * Calculates the Grade Point Average (GPA) for a student.
     * GPA = Sum of (Credit * Grade Point) / Sum of Credits
     * @param student The student for whom to calculate the GPA.
     * @return The calculated GPA.
     */
    public double calculateGpa(Student student) {
        if (student.getEnrolledCourses() == null || student.getEnrolledCourses().isEmpty()) {
            return 0.0;
        }

        double totalGradePoints = student.getEnrolledCourses().stream()
            .filter(e -> e.getGrade() != Grade.N) // Only consider graded courses
            .mapToDouble(e -> e.getCourse().getCredits() * e.getGrade().getGradePoint())
            .sum();

        int totalCredits = student.getEnrolledCourses().stream()
            .filter(e -> e.getGrade() != Grade.N)
            .mapToInt(e -> e.getCourse().getCredits())
            .sum();

        if (totalCredits == 0) {
            return 0.0;
        }
        
        // Round to 2 decimal places
        return Math.round((totalGradePoints / totalCredits) * 100.0) / 100.0;
    }
}