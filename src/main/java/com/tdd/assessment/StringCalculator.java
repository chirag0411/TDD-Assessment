package com.tdd.assessment;


import org.apache.commons.lang3.StringUtils;

public class StringCalculator {

    public int add(String numbers) {
        if (!StringUtils.isBlank(numbers)) {
            String[] numList = splitNumbers(numbers);
            return sum(numList);
        }
        return 0;
    }

    private String[] splitNumbers(String numbers) {
        return numbers.split(",");
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