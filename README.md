# RewardsService Implementation

This project implements a RewardsService that determines which rewards customers are eligible for based on their channel subscriptions.

## Overview

The RewardsService interacts with an EligibilityService to determine if a customer is eligible for rewards based on their account number. If eligible, the service returns a list of rewards that correspond to the customer's channel subscriptions.

## Features

- Determines rewards based on customer channel subscriptions
- Handles different eligibility statuses
- Properly handles technical failures and invalid account numbers
- Implemented using good object-oriented principles
- Extensively tested

## Project Structure

The project is organized into the following packages:

- `com.rewards.model`: Contains domain model classes (Customer, Portfolio, Channel, Reward)
- `com.rewards.service`: Contains service interfaces and exceptions
- `com.rewards.service.impl`: Contains implementations of the service interfaces
- `com.rewards.service.mock`: Contains mock implementations for testing

## Channel-Reward Mapping

The following channels map to rewards:

| Channel | Reward                              |
|---------|-------------------------------------|
| SPORTS  | CHAMPIONS_LEAGUE_FINAL_TICKET       |
| MUSIC   | KARAOKE_PRO_MICROPHONE              |
| MOVIES  | PIRATES_OF_THE_CARIBBEAN_COLLECTION |

KIDS and NEWS channels do not have associated rewards.

## Eligibility Service Responses

The RewardsService handles the following responses from the EligibilityService:

| EligibilityService Output        | RewardsService Result                                  |
|----------------------------------|----------------------------------------------------|
| CUSTOMER_ELIGIBLE                | Return rewards according to customer's portfolio    |
| CUSTOMER_INELIGIBLE              | Return no rewards                                   |
| Technical failure exception      | Return no rewards                                   |
| Invalid account number exception | Return no rewards and notify client of invalid account |

## Usage Example

```java
// Create an instance of the EligibilityService
EligibilityService eligibilityService = new MockEligibilityService();

// Create an instance of the RewardsService
RewardsService rewardsService = new RewardsServiceImpl(eligibilityService);

// Create a portfolio with subscriptions to SPORTS, MUSIC, and MOVIES channels
Portfolio portfolio = new Portfolio(EnumSet.of(Channel.SPORTS, Channel.MUSIC, Channel.MOVIES));

// Create a customer with an account number and portfolio
Customer customer = new Customer("EL12345", portfolio);

// Get eligible rewards
try {
    Set<Reward> rewards = rewardsService.getEligibleRewards(customer);
    
    // Process rewards...
} catch (InvalidAccountNumberException e) {
    // Handle invalid account number...
}
```

## Testing

The service is thoroughly tested using JUnit and Mockito. Tests cover all the expected behavior and edge cases, including:

- Eligible customers with various channel subscriptions
- Ineligible customers
- Technical failures
- Invalid account numbers
- Null inputs

## Design Considerations

The implementation follows SOLID principles and uses good object-oriented practices:

- Single Responsibility Principle: Each class has a single responsibility
- Open/Closed Principle: The design is open for extension but closed for modification
- Dependency Injection: Services are designed for proper dependency injection
- Immutability: Domain objects are immutable where appropriate
- Error Handling: Proper exception handling for all error cases

## Running the Application

The project includes a simple demonstration application in `com.rewards.RewardsApplication` that shows the service in action with different scenarios.
# RewardsService Implementation

This project implements a RewardsService that determines which rewards customers are eligible for based on their channel subscriptions.

## Overview

The RewardsService interacts with an EligibilityService to determine if a customer is eligible for rewards based on their account number. If eligible, the service returns a list of rewards that correspond to the customer's channel subscriptions.

## Features

- Determines rewards based on customer channel subscriptions
- Handles different eligibility statuses
- Properly handles technical failures and invalid account numbers
- Implemented using good object-oriented principles
- Extensively tested

## Project Structure

The project is organized into the following packages:

- `com.rewards.model`: Contains domain model classes (Customer, Portfolio, Channel, Reward)
- `com.rewards.service`: Contains service interfaces and exceptions
- `com.rewards.service.impl`: Contains implementations of the service interfaces
- `com.rewards.service.mock`: Contains mock implementations for testing

## Channel-Reward Mapping

The following channels map to rewards:

| Channel | Reward                              |
|---------|-------------------------------------|
| SPORTS  | CHAMPIONS_LEAGUE_FINAL_TICKET       |
| MUSIC   | KARAOKE_PRO_MICROPHONE              |
| MOVIES  | PIRATES_OF_THE_CARIBBEAN_COLLECTION |

KIDS and NEWS channels do not have associated rewards.

## Eligibility Service Responses

The RewardsService handles the following responses from the EligibilityService:

| EligibilityService Output        | RewardsService Result                                  |
|----------------------------------|----------------------------------------------------|
| CUSTOMER_ELIGIBLE                | Return rewards according to customer's portfolio    |
| CUSTOMER_INELIGIBLE              | Return no rewards                                   |
| Technical failure exception      | Return no rewards                                   |
| Invalid account number exception | Return no rewards and notify client of invalid account |

## Usage Example

```java
// Create an instance of the EligibilityService
EligibilityService eligibilityService = new MockEligibilityService();

// Create an instance of the RewardsService
RewardsService rewardsService = new RewardsServiceImpl(eligibilityService);

// Create a portfolio with subscriptions to SPORTS, MUSIC, and MOVIES channels
Portfolio portfolio = new Portfolio(EnumSet.of(Channel.SPORTS, Channel.MUSIC, Channel.MOVIES));

// Create a customer with an account number and portfolio
Customer customer = new Customer("EL12345", portfolio);

// Get eligible rewards
try {
    Set<Reward> rewards = rewardsService.getEligibleRewards(customer);
    
    // Process rewards...
} catch (InvalidAccountNumberException e) {
    // Handle invalid account number...
}
```

## Testing

The service is thoroughly tested using JUnit and Mockito. Tests cover all the expected behavior and edge cases, including:

- Eligible customers with various channel subscriptions
- Ineligible customers
- Technical failures
- Invalid account numbers
- Null inputs

## Design Considerations

The implementation follows SOLID principles and uses good object-oriented practices:

- Single Responsibility Principle: Each class has a single responsibility
- Open/Closed Principle: The design is open for extension but closed for modification
- Dependency Injection: Services are designed for proper dependency injection
- Immutability: Domain objects are immutable where appropriate
- Error Handling: Proper exception handling for all error cases

## Running the Application

The project includes a simple demonstration application in `com.rewards.RewardsApplication` that shows the service in action with different scenarios.