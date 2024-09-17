package com.tdd.assessment;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @Mock
    private StringCalculator stringCalculatorMock;

    @BeforeEach
    public void init() {
        stringCalculator = new StringCalculator();
        MockitoAnnotations.openMocks(this);
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
    @DisplayName("Test New Line Delimiter")
    public void testNewLineDelimiter() {
        assertEquals(10, stringCalculator.add("1\n2,3\n4"));
    }

    @Test
    @DisplayName("Test Different Delimiters")
    public void testDifferentDelimiters() {
        assertEquals(15, stringCalculator.add("//;\n1;2;3;4;5"));
    }

    @Test
    @DisplayName("Test Negative Number")
    public void testNegativeNumber() {
        try {
            stringCalculator.add("10,-20,30,-10");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Negative numbers not allowed: -20,-10");
        }
    }

    @Test
    @DisplayName("Test Over Thousand")
    public void testOverThousand() {
        assertEquals(22, stringCalculator.add("1000,10,12,1001"));
    }

    @Test
    void testAdd_ConvertToIntThrowsNumberFormatException_ReturnsZero() {
        when(stringCalculatorMock.add(anyString())).thenCallRealMethod();
        when(stringCalculatorMock.convertToInt(anyString())).thenThrow(NumberFormatException.class);
        assertThrows(NumberFormatException.class, () -> stringCalculatorMock.add("1,3a"));
    }
}