package com.tdd.assessment;


import org.apache.commons.lang3.StringUtils;

public class StringCalculator {

    public long sum(String input) {
        if (!StringUtils.isBlank(input)) {
            return 1;
        }
        return 0;
    }
}