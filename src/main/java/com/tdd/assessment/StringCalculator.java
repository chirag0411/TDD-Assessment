package com.tdd.assessment;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {

    public int add(String numbers) {
        if (!StringUtils.isBlank(numbers)) {
            String delimiter = ",";
            if (numbers.matches("//(.*)\n(.*)")) {
                delimiter = Character.toString(numbers.charAt(2));
                numbers = numbers.substring(4);
            }

            String[] numList = splitNumbers(numbers, delimiter + "|\n");
            return sum(numList);
        }
        return 0;
    }

    private String[] splitNumbers(String numbers, String delimiter) {
        return numbers.split(delimiter);
    }


    private int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            total += convertToInt(number);
        }
        return total;
    }

    private int convertToInt(String num) {
        return Integer.parseInt(num);
    }
}