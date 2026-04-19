package com.rewards.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit tests for {@link StringReverser}.
 *
 * <p>Covers: normal word, sentence with spaces, empty string, null input,
 * single character, palindrome, and strings containing special characters
 * and digits.</p>
 */
@DisplayName("StringReverser")
class StringReverserTest {

    @Test
    @DisplayName("reverse() returns characters in reverse order for a normal word")
    void reverse_normalWord_returnsReversedWord() {
        assertEquals("olleh", StringReverser.reverse("hello"));
    }

    @Test
    @DisplayName("reverse() reverses a sentence preserving spaces")
    void reverse_sentenceWithSpaces_preservesSpacesInReversedOrder() {
        assertEquals("dlrow olleh", StringReverser.reverse("hello world"));
    }

    @Test
    @DisplayName("reverse() returns an empty string when given an empty string")
    void reverse_emptyString_returnsEmptyString() {
        assertEquals("", StringReverser.reverse(""));
    }

    @Test
    @DisplayName("reverse() throws IllegalArgumentException when input is null")
    void reverse_nullInput_throwsIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> StringReverser.reverse(null)
        );
        assertEquals("Input string must not be null", exception.getMessage());
    }

    @Test
    @DisplayName("reverse() returns the same single character unchanged")
    void reverse_singleCharacter_returnsSameCharacter() {
        assertEquals("a", StringReverser.reverse("a"));
    }

    @Test
    @DisplayName("reverse() returns a palindrome unchanged")
    void reverse_palindrome_returnsSameString() {
        assertEquals("racecar", StringReverser.reverse("racecar"));
    }

    @Test
    @DisplayName("reverse() correctly reverses a string containing special characters and digits")
    void reverse_specialCharactersAndDigits_returnsReversedString() {
        assertEquals("!321 #avaJ", StringReverser.reverse("Java# 123!"));
    }
}
