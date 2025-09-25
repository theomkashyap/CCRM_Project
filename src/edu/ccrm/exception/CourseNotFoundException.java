package edu.ccrm.exception;

public class CourseNotFoundException extends Exception {
    public CourseNotFoundException(String message) {
        super(message); // Pass the message to the parent Exception class
    }
}