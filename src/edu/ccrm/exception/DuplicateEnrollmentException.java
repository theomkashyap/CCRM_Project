package edu.ccrm.exception;

public class DuplicateEnrollmentException extends Exception {
    public DuplicateEnrollmentException(String message) {
        super(message); // Pass the message to the parent Exception class
    }
}