ackage com.leangains;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Mathematical Operations Program
 * 
 * This program performs the following operations:
 * 1. Takes input for ten numbers from the user
 * 2. Calculates and displays the sum of all ten numbers
 * 3. Allows the user to divide two specified numbers
 * 4. Allows the user to subtract two specified numbers
 * 
 * @author LeanGains Team
 * @version 1.0
 */
public class MathematicalOperations {
    
    private static final Scanner scanner = new Scanner(System.in);
    private static final int REQUIRED_NUMBERS = 10;
    
    public static void main(String[] args) {
        System.out.println("=== Mathematical Operations Program ===");
        System.out.println("Welcome! This program will help you perform various mathematical operations.");
        System.out.println();
        
        try {
            // Step 1: Get ten numbers from user
            List<Double> numbers = getTenNumbers();
            
            // Step 2: Calculate and display sum
            double sum = calculateSum(numbers);
            System.out.printf("\nThe sum of all %d numbers is: %.2f\n", REQUIRED_NUMBERS, sum);
            
            // Step 3: Perform division operation
            performDivisionOperation();
            
            // Step 4: Perform subtraction operation
            performSubtractionOperation();
            
            System.out.println("\nThank you for using the Mathematical Operations Program!");
            
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    
    /**
     * Collects ten numbers from the user with input validation
     * 
     * @return List of ten double values entered by the user
     */
    private static List<Double> getTenNumbers() {
        List<Double> numbers = new ArrayList<>();
        System.out.println("Please enter 10 numbers (can be integers or decimals):");
        
        for (int i = 1; i <= REQUIRED_NUMBERS; i++) {
            while (true) {
                try {
                    System.out.printf("Enter number %d: ", i);
                    double number = scanner.nextDouble();
                    numbers.add(number);
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a valid number.");
                    scanner.nextLine(); // Clear the invalid input
                }
            }
        }
        
        System.out.println("\nNumbers entered successfully!");
        displayNumbers(numbers);
        return numbers;
    }
    
    /**
     * Displays the list of numbers in a formatted way
     * 
     * @param numbers List of numbers to display
     */
    private static void displayNumbers(List<Double> numbers) {
        System.out.print("Your numbers: ");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.printf("%.2f", numbers.get(i));
            if (i < numbers.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    
    /**
     * Calculates the sum of all numbers in the list
     * 
     * @param numbers List of numbers to sum
     * @return The sum of all numbers
     */
    private static double calculateSum(List<Double> numbers) {
        return numbers.stream().mapToDouble(Double::doubleValue).sum();
    }
    
    /**
     * Performs division operation on two user-specified numbers
     */
    private static void performDivisionOperation() {
        System.out.println("\n=== Division Operation ===");
        
        double dividend = getNumberFromUser("Enter the dividend (number to be divided): ");
        double divisor = getNumberFromUser("Enter the divisor (number to divide by): ");
        
        try {
            double result = divide(dividend, divisor);
            System.out.printf("Result: %.2f ÷ %.2f = %.6f\n", dividend, divisor, result);
        } catch (ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    /**
     * Performs subtraction operation on two user-specified numbers
     */
    private static void performSubtractionOperation() {
        System.out.println("\n=== Subtraction Operation ===");
        
        double minuend = getNumberFromUser("Enter the minuend (number to subtract from): ");
        double subtrahend = getNumberFromUser("Enter the subtrahend (number to subtract): ");
        
        double result = subtract(minuend, subtrahend);
        System.out.printf("Result: %.2f - %.2f = %.2f\n", minuend, subtrahend, result);
    }
    
    /**
     * Gets a single number from the user with input validation
     * 
     * @param prompt The prompt message to display to the user
     * @return The number entered by the user
     */
    private static double getNumberFromUser(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }
    
    /**
     * Divides two numbers with division by zero protection
     * 
     * @param dividend The number to be divided
     * @param divisor The number to divide by
     * @return The result of the division
     * @throws ArithmeticException if divisor is zero
     */
    private static double divide(double dividend, double divisor) throws ArithmeticException {
        if (divisor == 0.0) {
            throw new ArithmeticException("Division by zero is not allowed!");
        }
        return dividend / divisor;
    }
    
    /**
     * Subtracts the second number from the first number
     * 
     * @param minuend The number to subtract from
     * @param subtrahend The number to subtract
     * @return The result of the subtraction
     */
    private static double subtract(double minuend, double subtrahend) {
        return minuend - subtrahend;
    }
}