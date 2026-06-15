ackage com.leangains;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for ConcatenateThree.
 *
 * <p>These tests use JUnit 5. They are lightweight and exercise the public static
 * concatenate method's behavior including null handling and empty strings.</p>
 */
public class ConcatenateThreeTest {

    @Test
    public void testConcatenate_allNonNull() {
        assertEquals("abc", ConcatenateThree.concatenate("a", "b", "c"));
    }

    @Test
    public void testConcatenate_containsSpace() {
        assertEquals("hello world", ConcatenateThree.concatenate("hello", " ", "world"));
    }

    @Test
    public void testConcatenate_nullInputs() {
        assertEquals("x", ConcatenateThree.concatenate(null, "x", null));
    }

    @Test
    public void testConcatenate_emptyStrings() {
        assertEquals("", ConcatenateThree.concatenate("", "", ""));
    }
}
