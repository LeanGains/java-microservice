package com.rewards.service;

import com.rewards.model.Channel;
import com.rewards.model.Customer;
import com.rewards.model.Portfolio;
import com.rewards.model.Reward;
import com.rewards.service.impl.RewardsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Unit tests for the RewardsServiceImpl class.
 */
public class RewardsServiceTest {
    
    @Mock
    private EligibilityService mockEligibilityService;
    
    private RewardsService rewardsService;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        rewardsService = new RewardsServiceImpl(mockEligibilityService);
    }
    
    @Test
    public void testEligibleCustomerWithAllChannels() throws Exception {
        // Arrange
        String accountNumber = "TEST123";
        Portfolio portfolio = new Portfolio(EnumSet.allOf(Channel.class));
        Customer customer = new Customer(accountNumber, portfolio);
        
        when(mockEligibilityService.checkEligibility(accountNumber))
                .thenReturn(EligibilityStatus.CUSTOMER_ELIGIBLE);
        
        // Act
        Set<Reward> rewards = rewardsService.getEligibleRewards(customer);
        
        // Assert
        assertEquals(3, rewards.size());
        assertTrue(rewards.contains(Reward.CHAMPIONS_LEAGUE_FINAL_TICKET));
        assertTrue(rewards.contains(Reward.KARAOKE_PRO_MICROPHONE));
        assertTrue(rewards.contains(Reward.PIRATES_OF_THE_CARIBBEAN_COLLECTION));
    }
    
    @Test
    public void testEligibleCustomerWithSomeChannels() throws Exception {
        // Arrange
        String accountNumber = "TEST456";
        Portfolio portfolio = new Portfolio(EnumSet.of(Channel.SPORTS, Channel.KIDS));
        Customer customer = new Customer(accountNumber, portfolio);
        
        when(mockEligibilityService.checkEligibility(accountNumber))
                .thenReturn(EligibilityStatus.CUSTOMER_ELIGIBLE);
        
        // Act
        Set<Reward> rewards = rewardsService.getEligibleRewards(customer);
        
        // Assert
        assertEquals(1, rewards.size());
        assertTrue(rewards.contains(Reward.CHAMPIONS_LEAGUE_FINAL_TICKET));
    }
    
    @Test
    public void testEligibleCustomerWithNoRewardChannels() throws Exception {
        // Arrange
        String accountNumber = "TEST789";
        Portfolio portfolio = new Portfolio(EnumSet.of(Channel.KIDS, Channel.NEWS));
        Customer customer = new Customer(accountNumber, portfolio);
        
        when(mockEligibilityService.checkEligibility(accountNumber))
                .thenReturn(EligibilityStatus.CUSTOMER_ELIGIBLE);
        
        // Act
        Set<Reward> rewards = rewardsService.getEligibleRewards(customer);
        
        // Assert
        assertTrue(rewards.isEmpty());
    }
    
    @Test
    public void testIneligibleCustomer() throws Exception {
        // Arrange
        String accountNumber = "TEST101";
        Portfolio portfolio = new Portfolio(EnumSet.allOf(Channel.class));
        Customer customer = new Customer(accountNumber, portfolio);
        
        when(mockEligibilityService.checkEligibility(accountNumber))
                .thenReturn(EligibilityStatus.CUSTOMER_INELIGIBLE);
        
        // Act
        Set<Reward> rewards = rewardsService.getEligibleRewards(customer);
        
        // Assert
        assertTrue(rewards.isEmpty());
    }
    
    @Test
    public void testTechnicalFailure() throws Exception {
        // Arrange
        String accountNumber = "TEST202";
        Portfolio portfolio = new Portfolio(EnumSet.allOf(Channel.class));
        Customer customer = new Customer(accountNumber, portfolio);
        
        when(mockEligibilityService.checkEligibility(accountNumber))
                .thenThrow(new TechnicalFailureException("Technical failure"));
        
        // Act
        Set<Reward> rewards = rewardsService.getEligibleRewards(customer);
        
        // Assert
        assertTrue(rewards.isEmpty());
    }
    
    @Test
    public void testInvalidAccountNumber() {
        // Arrange
        String accountNumber = "TEST303";
        Portfolio portfolio = new Portfolio(EnumSet.allOf(Channel.class));
        Customer customer = new Customer(accountNumber, portfolio);
        
        when(mockEligibilityService.checkEligibility(accountNumber))
                .thenThrow(new InvalidAccountNumberException("Invalid account number"));
        
        // Act & Assert
        assertThrows(InvalidAccountNumberException.class, () -> rewardsService.getEligibleRewards(customer));
    }
    
    @Test
    public void testNullCustomer() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> rewardsService.getEligibleRewards(null));
    }
}