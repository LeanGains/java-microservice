package com.leangains;

/**
 * Minimal utility for converting strings to uppercase with null-safety.
 */
public final class UpperCaseConverter {

    private UpperCaseConverter() {
        // Prevent instantiation.
    }

    /**
     * Converts the provided input string to uppercase.
     *
     * @param input the input string; may be null
     * @return the uppercase version of {@code input}, or null if {@code input} is null
     */
    public static String toUpperCase(final String input) {
        return input == null ? null : input.toUpperCase();
    }

    /**
     * Demonstrates usage.
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
        final String input;
        if (args != null && args.length > 0) {
            input = String.join(" ", args);
        } else {
            input = "LeanGains";
        }

        final String result = toUpperCase(input);
        System.out.println(result);
    }
}
