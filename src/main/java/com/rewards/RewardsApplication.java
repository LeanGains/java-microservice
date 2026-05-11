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

/**
 * Example application demonstrating the usage of the RewardsService.
 */
public class RewardsApplication {
    
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
            
            System.out.println("Eligible customer rewards:");
            if (rewards.isEmpty()) {
                System.out.println("  No rewards available");
            } else {
                for (Reward reward : rewards) {
                    System.out.println("  " + reward);
                }
            }
        } catch (InvalidAccountNumberException e) {
            System.out.println("Error with eligible customer: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void demonstrateIneligibleCustomer(RewardsService rewardsService, Portfolio portfolio) {
        try {
            Customer customer = new Customer("IN12345", portfolio);
            Set<Reward> rewards = rewardsService.getEligibleRewards(customer);
            
            System.out.println("Ineligible customer rewards:");
            if (rewards.isEmpty()) {
                System.out.println("  No rewards available");
            } else {
                for (Reward reward : rewards) {
                    System.out.println("  " + reward);
                }
            }
        } catch (InvalidAccountNumberException e) {
            System.out.println("Error with ineligible customer: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void demonstrateTechnicalFailure(RewardsService rewardsService, Portfolio portfolio) {
        try {
            Customer customer = new Customer("TF12345", portfolio);
            Set<Reward> rewards = rewardsService.getEligibleRewards(customer);
            
            System.out.println("Technical failure customer rewards:");
            if (rewards.isEmpty()) {
                System.out.println("  No rewards available");
            } else {
                for (Reward reward : rewards) {
                    System.out.println("  " + reward);
                }
            }
        } catch (InvalidAccountNumberException e) {
            System.out.println("Error with technical failure customer: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void demonstrateInvalidAccountNumber(RewardsService rewardsService, Portfolio portfolio) {
        try {
            Customer customer = new Customer("IV12345", portfolio);
            Set<Reward> rewards = rewardsService.getEligibleRewards(customer);
            
            System.out.println("Invalid account number customer rewards:");
            if (rewards.isEmpty()) {
                System.out.println("  No rewards available");
            } else {
                for (Reward reward : rewards) {
                    System.out.println("  " + reward);
                }
            }
        } catch (InvalidAccountNumberException e) {
            System.out.println("Error with invalid account customer: " + e.getMessage());
            System.out.println("  " + e.getMessage());
        }
        System.out.println();
    }
}