package com.leangains;

/**
 * A simple command-line utility that prints an input string and its reverse.
 */
public final class ReverseStringPrinter {

    private static final String DEFAULT_INPUT = "Hello LeanGains";

    private ReverseStringPrinter() {
        // Prevent instantiation.
    }

    public static void main(final String[] args) {
        final String input = (args != null && args.length >= 1) ? args[0] : DEFAULT_INPUT;

        System.out.println(input);
        System.out.println(reverse(input));
    }

    /**
     * Reverses the provided string.
     *
     * @param s the input string
     * @return the reversed string, or {@code null} if {@code s} is {@code null}
     */
    public static String reverse(final String s) {
        if (s == null) {
            return null;
        }
        if (s.length() <= 1) {
            return s;
        }
        return new StringBuilder(s).reverse().toString();
    }
}
