package com.rewards.service;

/**
 * Interface for the eligibility service developed by the Customer Status team.
 * This service determines if a customer is eligible for rewards.
 */
public interface EligibilityService {
    
    /**
     * Checks the eligibility of a customer based on their account number.
     * 
     * @param accountNumber The customer's account number
     * @return The eligibility status of the customer
     * @throws TechnicalFailureException when a technical failure occurs
     * @throws InvalidAccountNumberException when the provided account number is invalid
     */
    EligibilityStatus checkEligibility(String accountNumber) 
            throws TechnicalFailureException, InvalidAccountNumberException;
}