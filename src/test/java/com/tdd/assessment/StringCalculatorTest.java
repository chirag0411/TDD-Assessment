package com.tdd.assessment;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class StringCalculatorTest {
    StringCalculator stringCalculator;

    @BeforeEach
    public void init() {
        stringCalculator = new StringCalculator();
    }

    @AfterEach
    public void destroy() {
        stringCalculator = null;
    }

    @Test
    @DisplayName("Test Empty String")
    public void returnZeroForEmptyOrNUllString() {
        assertEquals(0, stringCalculator.add(""));
        assertEquals(0, stringCalculator.add(null));
        assertEquals(0, stringCalculator.add("       "));
    }

    @Test
    @DisplayName("Test One Number")
    public void testAddOneNumber() {
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    @DisplayName("Test Multiple Numbers")
    public void testAddMultipleNumbers() {
        assertEquals(3, stringCalculator.add("1,2"));
        assertEquals(31, stringCalculator.add("1,2,1,2,2,1,2,2,1,2,2,1,2,2,1,2,2,1,2"));
    }

    @Test
    @DisplayName("Test New Line")
    public void testNewLine() {
        assertEquals(10, stringCalculator.add("1\n2,3\n4"));
    }

    @Test
    @DisplayName("Test Different Delimiters")
    public void testDifferentDelimiters() {
        assertEquals(15, stringCalculator.add("//;\n1;2;3;4;5"));
    }

}