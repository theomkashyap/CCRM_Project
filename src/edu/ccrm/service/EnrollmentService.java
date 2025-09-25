package edu.ccrm.service;

// --- ADD THESE IMPORTS ---
import edu.ccrm.domain.Course;
import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.Grade;
import edu.ccrm.domain.Student;
import edu.ccrm.exception.CourseNotFoundException;
import edu.ccrm.exception.DuplicateEnrollmentException;
import edu.ccrm.exception.MaxCreditLimitExceededException;
import edu.ccrm.util.ConsoleColors;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
// --- END OF IMPORTS ---

public class EnrollmentService {
    private final IStudentService studentService;
    private final CourseService courseService;
    private final List<Enrollment> enrollments = new CopyOnWriteArrayList<>();
    private static final int MAX_CREDITS_PER_SEMESTER = 25;

    public EnrollmentService(IStudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public void enrollStudent(int studentId, String courseCode) 
            throws MaxCreditLimitExceededException, DuplicateEnrollmentException, CourseNotFoundException {
        
        Student student = studentService.findStudentById(studentId)
            .orElseThrow(() -> new IllegalArgumentException("Student with ID " + studentId + " not found."));

        Course course = courseService.findCourseByCode(courseCode)
            .orElseThrow(() -> new CourseNotFoundException("Course with code " + courseCode + " not found."));

        boolean alreadyEnrolled = student.getEnrolledCourses().stream()
            .anyMatch(e -> e.getCourse().getCode().equalsIgnoreCase(courseCode));
        if (alreadyEnrolled) {
            throw new DuplicateEnrollmentException("Student is already enrolled in " + courseCode);
        }

        int currentCredits = student.getEnrolledCourses().stream()
            .mapToInt(e -> e.getCourse().getCredits())
            .sum();
        
        assert currentCredits >= 0 : "Current credits cannot be negative.";

        if (currentCredits + course.getCredits() > MAX_CREDITS_PER_SEMESTER) {
            throw new MaxCreditLimitExceededException("Cannot enroll. Exceeds max credit limit of " + MAX_CREDITS_PER_SEMESTER);
        }

        Enrollment enrollment = new Enrollment(student, course);
        enrollments.add(enrollment);
        student.addEnrollment(enrollment);

        System.out.println(ConsoleColors.GREEN + "Enrollment successful! Enrollment ID: " + enrollment.getEnrollmentId() + ConsoleColors.RESET);
    }

    public Optional<Enrollment> findEnrollmentById(int enrollmentId) {
        return enrollments.stream().filter(e -> e.getEnrollmentId() == enrollmentId).findFirst();
    }

    public void assignGrade(int enrollmentId, Grade grade) {
        findEnrollmentById(enrollmentId).ifPresentOrElse(
            enrollment -> {
                enrollment.setGrade(grade);
                System.out.println(ConsoleColors.GREEN + "Grade assigned successfully." + ConsoleColors.RESET);
            },
            () -> System.out.println(ConsoleColors.RED + "Enrollment ID not found." + ConsoleColors.RESET)
        );
    }
}