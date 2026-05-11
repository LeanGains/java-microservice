package com.rewards.service;

/**
 * Exception thrown when a technical failure occurs during eligibility check.
 */
public class TechnicalFailureException extends Exception {
    
    public TechnicalFailureException(String message) {
        super(message);
    }
    
    public TechnicalFailureException(String message, Throwable cause) {
        super(message, cause);
    }
}