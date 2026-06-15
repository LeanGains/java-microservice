ackage com.leangains.microservice;

/**
 * HelloWorldReverse - A utility class that reverses and prints "Hello World".
 * 
 * This class demonstrates basic string manipulation by reversing the text
 * "Hello World" to "dlroW olleH" and printing it to the console.
 * 
 * @author Leangains Microservice Team
 * @version 1.0
 */
public class HelloWorldReverse {
    
    private static final String ORIGINAL_MESSAGE = "Hello World";
    
    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private HelloWorldReverse() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }
    
    /**
     * Reverses a given string using StringBuilder.
     * 
     * @param input the string to be reversed
     * @return the reversed string
     * @throws IllegalArgumentException if input is null
     */
    public static String reverseString(final String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        return new StringBuilder(input).reverse().toString();
    }
    
    /**
     * Main entry point of the application.
     * Reverses "Hello World" and prints it to the console.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(final String[] args) {
        try {
            final String reversedMessage = reverseString(ORIGINAL_MESSAGE);
            System.out.println(reversedMessage);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}
