package com.leangains.utils;

import java.util.Collection;

/**
 * Small utility class for summing n numbers.
 *
 * <p>Provides overloads for primitive varargs (long and double) and a convenience
 * method to sum boxed Number instances from a Collection.
 *
 * <p>All methods are null-safe and return 0 when given null or empty inputs.
 */
public final class NumberAdder {

    private NumberAdder() {
        // prevent instantiation
    }

    /**
     * Sum the given long values. Returns 0 if the input is null or empty.
     *
     * @param numbers long values to sum
     * @return the sum of the provided values, or 0L for null/empty input
     */
    public static long sum(long... numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0L;
        }
        long total = 0L;
        for (long n : numbers) {
            total += n;
        }
        return total;
    }

    /**
     * Sum the given double values. Returns 0.0 if the input is null or empty.
     *
     * @param numbers double values to sum
     * @return the sum of the provided values, or 0.0 for null/empty input
     */
    public static double sum(double... numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0.0;
        }
        double total = 0.0;
        for (double n : numbers) {
            total += n;
        }
        return total;
    }

    /**
     * Sum a collection of Number instances. Null or empty collection returns 0.0.
     * Values are summed as doubles; null elements are ignored.
     *
     * @param numbers collection of Number instances
     * @return the sum as a double, or 0.0 for null/empty input
     */
    public static double sum(Collection<? extends Number> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0.0;
        }
        double total = 0.0;
        for (Number n : numbers) {
            if (n != null) {
                total += n.doubleValue();
            }
        }
        return total;
    }
}
