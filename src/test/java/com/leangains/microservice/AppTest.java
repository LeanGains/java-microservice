package com.leangains.microservice;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testApp() {
        // Redirect System.out to capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Run the main method
        App.main(new String[]{});

        // Restore original System.out
        System.setOut(originalOut);

        // Assert the output is correct, accounting for line separator differences
        assertEquals("Hello World!" + System.lineSeparator(), outContent.toString());
    }
}