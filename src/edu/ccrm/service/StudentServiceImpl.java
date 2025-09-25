package edu.ccrm.service;

import edu.ccrm.domain.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class StudentServiceImpl implements IStudentService {
    private final List<Student> students = new CopyOnWriteArrayList<>();
    private int nextId = 1;

    @Override
    public void addStudent(Student student) {
        // In a real app, you'd check for duplicate regNo, etc.
        students.add(student);
    }

    @Override
    public Optional<Student> findStudentById(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst();
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(students); // Return a copy
    }

    @Override
    public void updateStudent(Student student) {
        // Logic to find and update student
    }
}