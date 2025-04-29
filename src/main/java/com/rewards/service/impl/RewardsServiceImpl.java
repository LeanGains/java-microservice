package com.rewards.service.impl;

import com.rewards.model.Channel;
import com.rewards.model.Customer;
import com.rewards.model.Portfolio;
import com.rewards.model.Reward;
import com.rewards.service.EligibilityService;
import com.rewards.service.EligibilityStatus;
import com.rewards.service.InvalidAccountNumberException;
import com.rewards.service.RewardsService;
import com.rewards.service.TechnicalFailureException;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementation of the RewardsService that determines which rewards customers are eligible for
 * based on their channel subscriptions.
 */
public class RewardsServiceImpl implements RewardsService {
    
    private static final Logger LOGGER = Logger.getLogger(RewardsServiceImpl.class.getName());
    
    private final EligibilityService eligibilityService;
    private final Map<Channel, Reward> channelRewardMap;
    
    /**
     * Creates a new RewardsServiceImpl with the given eligibility service.
     * 
     * @param eligibilityService The service to determine customer eligibility
     */
    public RewardsServiceImpl(EligibilityService eligibilityService) {
        this.eligibilityService = eligibilityService;
        this.channelRewardMap = initializeChannelRewardMap();
    }
    
    /**
     * Initializes the mapping of channels to rewards based on the requirements.
     * 
     * @return A map of channels to their corresponding rewards
     */
    private Map<Channel, Reward> initializeChannelRewardMap() {
        Map<Channel, Reward> map = new EnumMap<>(Channel.class);
        map.put(Channel.SPORTS, Reward.CHAMPIONS_LEAGUE_FINAL_TICKET);
        map.put(Channel.MUSIC, Reward.KARAOKE_PRO_MICROPHONE);
        map.put(Channel.MOVIES, Reward.PIRATES_OF_THE_CARIBBEAN_COLLECTION);
        // KIDS and NEWS channels have no associated rewards
        return Collections.unmodifiableMap(map);
    }
    
    @Override
    public Set<Reward> getEligibleRewards(Customer customer) throws InvalidAccountNumberException {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        
        String accountNumber = customer.getAccountNumber();
        Portfolio portfolio = customer.getPortfolio();
        
        try {
            EligibilityStatus eligibilityStatus = eligibilityService.checkEligibility(accountNumber);
            
            if (eligibilityStatus == EligibilityStatus.CUSTOMER_ELIGIBLE) {
                return getRewardsForEligibleCustomer(portfolio);
            } else {
                // Customer is ineligible, return empty set
                return Collections.emptySet();
            }
        } catch (TechnicalFailureException e) {
            LOGGER.log(Level.WARNING, "Technical failure while checking eligibility for account: " + accountNumber, e);
            // Return empty set on technical failure
            return Collections.emptySet();
        } catch (InvalidAccountNumberException e) {
            LOGGER.log(Level.WARNING, "Invalid account number provided: " + accountNumber, e);
            // Rethrow the exception to notify client of invalid account
            throw e;
        }
    }
    
    /**
     * Determines the rewards for an eligible customer based on their channel subscriptions.
     * 
     * @param portfolio The customer's portfolio of channel subscriptions
     * @return The set of rewards the customer is eligible for
     */
    private Set<Reward> getRewardsForEligibleCustomer(Portfolio portfolio) {
        Set<Reward> eligibleRewards = new HashSet<>();
        
        for (Channel channel : portfolio.getChannelSubscriptions()) {
            if (channelRewardMap.containsKey(channel)) {
                eligibleRewards.add(channelRewardMap.get(channel));
            }
        }
        
        return eligibleRewards;
    }
}