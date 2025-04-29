package com.rewards.model;

/**
 * Represents a customer with an account number and a portfolio of subscriptions.
 */
public class Customer {
    private final String accountNumber;
    private final Portfolio portfolio;
    
    /**
     * Creates a new Customer with the given account number and portfolio.
     * 
     * @param accountNumber The customer's account number
     * @param portfolio The customer's portfolio of channel subscriptions
     */
    public Customer(String accountNumber, Portfolio portfolio) {
        this.accountNumber = accountNumber;
        this.portfolio = portfolio;
    }
    
    /**
     * Returns the customer's account number.
     * 
     * @return The account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }
    
    /**
     * Returns the customer's portfolio.
     * 
     * @return The portfolio
     */
    public Portfolio getPortfolio() {
        return portfolio;
    }
}