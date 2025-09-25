package edu.ccrm.exception;

public class MaxCreditLimitExceededException extends Exception {
    public MaxCreditLimitExceededException(String message) {
        super(message); // Pass the message to the parent Exception class
    }
}