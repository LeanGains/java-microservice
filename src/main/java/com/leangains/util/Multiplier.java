ackage com.leangains.util;

/**
 * Utility class that provides multiplication helpers for three numbers.
 *
 * <p>Provides simple, static helpers for multiplying three values. The integer
 * overload returns a {@code long} to reduce the risk of overflow when
 * multiplying large {@code int} values.</p>
 *
 * <p>Usage example:
 * <pre>
 * long prod = Multiplier.multiply(2, 3, 4); // 24
 * double dprod = Multiplier.multiply(1.5, 2.0, 3.0); // 9.0
 * </pre>
 * </p>
 */
public final class Multiplier {

    // Prevent instantiation
    private Multiplier() {
        throw new AssertionError("Multiplier is a utility class and must not be instantiated");
    }

    /**
     * Multiplies three integers and returns the result as a long.
     *
     * @param a first integer
     * @param b second integer
     * @param c third integer
     * @return product as a long
     */
    public static long multiply(int a, int b, int c) {
        // Cast the first operand to long to promote subsequent multiplication
        // to long and reduce risk of intermediate overflow.
        return (long) a * b * c;
    }

    /**
     * Multiplies three double values and returns the result as a double.
     *
     * @param a first value
     * @param b second value
     * @param c third value
     * @return product as a double
     */
    public static double multiply(double a, double b, double c) {
        return a * b * c;
    }

    /**
     * Simple demonstration entry point.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        System.out.println("int product: " + Multiplier.multiply(2, 3, 4)); // prints 24
        System.out.println("double product: " + Multiplier.multiply(1.5, 2.0, 3.0)); // prints 9.0
    }
}
