package com.tdd.assessment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class StringCalculatorTest {

    @Mock
    StringCalculator stringCalculator;

    @Test
    public void returnZeroForEmptyOrNUllString() {
        assertEquals(0, stringCalculator.sum(""));
        assertEquals(0, stringCalculator.sum(null));
        assertEquals(0, stringCalculator.sum("       "));
    }
}