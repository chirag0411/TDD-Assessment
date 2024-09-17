package com.tdd.assessment;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class StringCalculator {

    public int add(String numbers) {
        if (StringUtils.isBlank(numbers)) {
            return 0;
        }

        String delimiter = ",";
        if (numbers.matches("//(.*)\n(.*)")) {
            delimiter = Character.toString(numbers.charAt(2));
            numbers = numbers.substring(4);
        }

        String[] numberArray = splitNumbers(numbers, delimiter + "|\n");
        return sum(numberArray);
    }

    private String[] splitNumbers(String numbers, String delimiter) {
        return numbers.split(delimiter);
    }

    private int sum(String[] numbers) {
        StringBuilder negativeNumbers = new StringBuilder();
        int total = Arrays.stream(numbers)
                .mapToInt(this::convertToInt)
                .peek(num -> {
                    if (num < 0) {
                        if (negativeNumbers.length() == 0) {
                            negativeNumbers.append(num);
                        } else {
                            negativeNumbers.append(",").append(num);
                        }
                    }
                })
                .filter(num -> num < 1000)
                .sum();

        if (negativeNumbers.length() > 0) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negativeNumbers);
        }
        return total;
    }

    int convertToInt(String num) {
        return Integer.parseInt(num);
    }
}