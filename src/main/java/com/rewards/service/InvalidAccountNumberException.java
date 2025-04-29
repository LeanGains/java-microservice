package com.rewards.service;

/**
 * Exception thrown when an invalid account number is provided.
 */
public class InvalidAccountNumberException extends Exception {
    
    public InvalidAccountNumberException(String message) {
        super(message);
    }
    
    public InvalidAccountNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}