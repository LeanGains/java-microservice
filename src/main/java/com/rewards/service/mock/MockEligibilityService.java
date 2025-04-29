package com.rewards.service.mock;

import com.rewards.service.EligibilityService;
import com.rewards.service.EligibilityStatus;
import com.rewards.service.InvalidAccountNumberException;
import com.rewards.service.TechnicalFailureException;

/**
 * A mock implementation of the EligibilityService interface for testing purposes.
 * This implementation simulates different responses based on account number patterns.
 */
public class MockEligibilityService implements EligibilityService {
    
    private static final String ELIGIBLE_PREFIX = "EL";
    private static final String INELIGIBLE_PREFIX = "IN";
    private static final String TECHNICAL_FAILURE_PREFIX = "TF";
    private static final String INVALID_ACCOUNT_PREFIX = "IV";
    
    @Override
    public EligibilityStatus checkEligibility(String accountNumber) 
            throws TechnicalFailureException, InvalidAccountNumberException {
        
        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new InvalidAccountNumberException("Account number cannot be null or empty");
        }
        
        // Simulate different behaviors based on account number patterns
        if (accountNumber.startsWith(ELIGIBLE_PREFIX)) {
            return EligibilityStatus.CUSTOMER_ELIGIBLE;
        } else if (accountNumber.startsWith(INELIGIBLE_PREFIX)) {
            return EligibilityStatus.CUSTOMER_INELIGIBLE;
        } else if (accountNumber.startsWith(TECHNICAL_FAILURE_PREFIX)) {
            throw new TechnicalFailureException("Technical failure occurred for account: " + accountNumber);
        } else if (accountNumber.startsWith(INVALID_ACCOUNT_PREFIX)) {
            throw new InvalidAccountNumberException("Invalid account number: " + accountNumber);
        }
        
        // Default behavior is eligible
        return EligibilityStatus.CUSTOMER_ELIGIBLE;
    }
}