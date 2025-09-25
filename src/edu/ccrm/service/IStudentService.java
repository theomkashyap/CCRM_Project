package edu.ccrm.service;

import edu.ccrm.domain.Student;
import java.util.List;
import java.util.Optional;

/**
 * Interface defining the contract for student management operations.
 * Demonstrates the use of interfaces for service layers.
 */
public interface IStudentService {
    void addStudent(Student student);
    Optional<Student> findStudentById(int id);
    List<Student> getAllStudents();
    void updateStudent(Student student);
}