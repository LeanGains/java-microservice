package com.rewards.service;

import com.rewards.model.Customer;
import com.rewards.model.Reward;

import java.util.Set;

/**
 * Interface for the rewards service that determines which rewards customers are eligible for
 * based on their channel subscriptions.
 */
public interface RewardsService {
    
    /**
     * Determines the rewards a customer is eligible for based on their channel subscriptions.
     * 
     * @param customer The customer with an account number and portfolio
     * @return A set of rewards the customer is eligible for
     * @throws InvalidAccountNumberException when the provided account number is invalid
     */
    Set<Reward> getEligibleRewards(Customer customer) throws InvalidAccountNumberException;
}