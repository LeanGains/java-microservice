package com.rewards;

import com.rewards.model.Channel;
import com.rewards.model.Customer;
import com.rewards.model.Portfolio;
import com.rewards.model.Reward;
import com.rewards.service.EligibilityService;
import com.rewards.service.InvalidAccountNumberException;
import com.rewards.service.RewardsService;
import com.rewards.service.impl.RewardsServiceImpl;
import com.rewards.service.mock.MockEligibilityService;

import java.util.EnumSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Example application demonstrating the usage of the RewardsService.
 */
public class RewardsApplication {
    
    private static final Logger LOGGER = Logger.getLogger(RewardsApplication.class.getName());
    
    public static void main(String[] args) {
        // Create an instance of the EligibilityService (using the mock implementation)
        EligibilityService eligibilityService = new MockEligibilityService();
        
        // Create an instance of the RewardsService
        RewardsService rewardsService = new RewardsServiceImpl(eligibilityService);
        
        // Create a portfolio with subscriptions to SPORTS, MUSIC, and MOVIES channels
        Portfolio portfolio = new Portfolio(EnumSet.of(Channel.SPORTS, Channel.MUSIC, Channel.MOVIES));
        
        // Test with an eligible customer (EL prefix)
        demonstrateEligibleCustomer(rewardsService, portfolio);
        
        // Test with an ineligible customer (IN prefix)
        demonstrateIneligibleCustomer(rewardsService, portfolio);
        
        // Test with a technical failure (TF prefix)
        demonstrateTechnicalFailure(rewardsService, portfolio);
        
        // Test with an invalid account number (IV prefix)
        demonstrateInvalidAccountNumber(rewardsService, portfolio);
    }
    
    private static void demonstrateEligibleCustomer(RewardsService rewardsService, Portfolio portfolio) {
        try {
            Customer customer = new Customer("EL12345", portfolio);
            Set<Reward> rewards = rewardsService.getEligibleRewards(customer);
            
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info("Eligible customer rewards:");
            }
            if (rewards.isEmpty()) {
                if (LOGGER.isLoggable(Level.INFO)) {
                    LOGGER.info("  No rewards available");
                }
            } else {
                if (LOGGER.isLoggable(Level.INFO)) {
                    for (Reward reward : rewards) {
                        LOGGER.info("  " + reward);
                    }
                }
            }
        } catch (InvalidAccountNumberException e) {
            if (LOGGER.isLoggable(Level.WARNING)) {
                LOGGER.warning("Error with eligible customer: " + e.getMessage());
            }
        }
        LOGGER.info("");
    }
    
    private static void demonstrateIneligibleCustomer(RewardsService rewardsService, Portfolio portfolio) {
        try {
            Customer customer = new Customer("IN12345", portfolio);
            Set<Reward> rewards = rewardsService.getEligibleRewards(customer);
            
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info("Ineligible customer rewards:");
            }
            if (rewards.isEmpty()) {
                LOGGER.info("  No rewards available");
            } else {
                for (Reward reward : rewards) {
                    LOGGER.info("  " + reward);
                }
            }
        } catch (InvalidAccountNumberException e) {
            LOGGER.warning("Error with ineligible customer: " + e.getMessage());
        }
        LOGGER.info("");
    }
    
    private static void demonstrateTechnicalFailure(RewardsService rewardsService, Portfolio portfolio) {
        try {
            Customer customer = new Customer("TF12345", portfolio);
            Set<Reward> rewards = rewardsService.getEligibleRewards(customer);
            
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info("Technical failure customer rewards:");
            }
            if (rewards.isEmpty()) {
                LOGGER.info("  No rewards available");
            } else {
                for (Reward reward : rewards) {
                    LOGGER.info("  " + reward);
                }
            }
        } catch (InvalidAccountNumberException e) {
            LOGGER.warning("Error with technical failure customer: " + e.getMessage());
        }
        LOGGER.info("");
    }
    
    private static void demonstrateInvalidAccountNumber(RewardsService rewardsService, Portfolio portfolio) {
        try {
            Customer customer = new Customer("IV12345", portfolio);
            Set<Reward> rewards = rewardsService.getEligibleRewards(customer);
            
            LOGGER.info("Invalid account number customer rewards:");
            if (rewards.isEmpty()) {
                LOGGER.info("  No rewards available");
            } else {
                for (Reward reward : rewards) {
                    LOGGER.info("  " + reward);
                }
            }
        } catch (InvalidAccountNumberException e) {
            LOGGER.warning("Error with invalid account customer: " + e.getMessage());
            if (LOGGER.isLoggable(Level.WARNING)) {
                LOGGER.warning("  " + e.getMessage());
            }
        }
        LOGGER.info("");
    }
}