ackage com.leangains;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Small utility program that concatenates three strings.
 *
 * <p>Null inputs are treated as empty strings to avoid NPEs.</p>
 *
 * <p>Public API:
 * - concatenate(String a, String b, String c)
 * - main(String[] args)
 * </p>
 */
public final class ConcatenateThree {
    private static final Logger LOGGER = Logger.getLogger(ConcatenateThree.class.getName());

    // Prevent instantiation
    private ConcatenateThree() {
        throw new AssertionError("No instances");
    }

    /**
     * Concatenates three strings, treating null inputs as empty strings.
     *
     * @param a first string (may be null)
     * @param b second string (may be null)
     * @param c third string (may be null)
     * @return concatenation of a, b and c with nulls treated as ""
     */
    public static String concatenate(final String a, final String b, final String c) {
        // Defensive: treat null as empty string
        final String first = (a == null) ? "" : a;
        final String second = (b == null) ? "" : b;
        final String third = (c == null) ? "" : c;

        // Use StringBuilder for efficient concatenation
        return new StringBuilder()
                .append(first)
                .append(second)
                .append(third)
                .toString();
    }

    /**
     * Main entry point. If exactly three command-line arguments are provided, concatenates them
     * and prints the result to stdout. Otherwise prints a short usage/help message.
     *
     * <p>Exits with status 0 after printing.</p>
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
        try {
            if (args != null && args.length == 3) {
                final String result = concatenate(args[0], args[1], args[2]);
                System.out.println(result);
            } else {
                // Single-line usage message, concise and clear
                System.out.println("Usage: java -cp <classpath> com.leangains.ConcatenateThree <str1> <str2> <str3>");
            }
        } catch (final Exception ex) {
            // Should not happen for normal operation, but log defensively and still exit 0
            LOGGER.log(Level.SEVERE, "Unexpected error in main", ex);
        } finally {
            // Per requirements: exit with status 0 after printing
            try {
                System.exit(0);
            } catch (final SecurityException se) {
                // If System.exit is prevented by a security manager (e.g., in some test runners), just return.
                LOGGER.log(Level.FINE, "Security manager prevented System.exit", se);
            }
        }
    }
}
