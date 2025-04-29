package com.rewards.service;

/**
 * Enumeration of possible eligibility statuses for a customer.
 */
public enum EligibilityStatus {
    /**
     * Customer is eligible for rewards based on their subscriptions.
     */
    CUSTOMER_ELIGIBLE,
    
    /**
     * Customer is not eligible for rewards.
     */
    CUSTOMER_INELIGIBLE
}