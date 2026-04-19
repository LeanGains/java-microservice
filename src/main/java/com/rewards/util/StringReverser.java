package com.rewards.util;

/**
 * Utility class providing string reversal functionality.
 *
 * <p>This class is stateless and all methods are static. It is not intended
 * to be instantiated.</p>
 */
public final class StringReverser {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private StringReverser() {
        throw new UnsupportedOperationException("StringReverser is a utility class and cannot be instantiated");
    }

    /**
     * Reverses the characters of the given string.
     *
     * <p>Edge case behaviour:</p>
     * <ul>
     *   <li>A {@code null} input throws {@link IllegalArgumentException}.</li>
     *   <li>An empty string returns an empty string.</li>
     *   <li>A single-character string returns that same string unchanged.</li>
     * </ul>
     *
     * @param input the string to reverse; must not be {@code null}
     * @return a new string whose characters are in reverse order relative to {@code input}
     * @throws IllegalArgumentException if {@code input} is {@code null}
     */
    public static String reverse(final String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input string must not be null");
        }

        if (input.isEmpty() || input.length() == 1) {
            return input;
        }

        return new StringBuilder(input).reverse().toString();
    }
}
