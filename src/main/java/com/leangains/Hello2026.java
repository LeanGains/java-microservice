ackage com.leangains;

/**
 * Simple standalone class that prints a greeting for 2026.
 *
 * <p>Placed under the standard src/main/java layout so it can be built with Maven/Gradle or
 * compiled directly with javac.</p>
 */
public final class Hello2026 {

    // Prevent instantiation
    private Hello2026() {
        throw new AssertionError("No instances allowed");
    }

    /**
     * Entry point. Prints the greeting to stdout.
     *
     * @param args command line arguments (ignored)
     */
    public static void main(String[] args) {
        System.out.println(sayHello());
    }

    /**
     * Returns the greeting string. Separated from main so it can be used in tests or other code.
     *
     * @return the greeting string "Hello 2026"
     */
    public static String sayHello() {
        return "Hello 2026";
    }
}
