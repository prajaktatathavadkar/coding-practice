package com.programcreek.algorithms.string;

import java.util.HashMap;

/**
 * @author ptathavadkar
 */
public class StringToInteger {

    private static final HashMap<Character, Integer> integerMap
            = new HashMap<Character, Integer>(){{
                put('0', 0);
                put('1', 1);
                put('2', 2);
                put('3', 3);
                put('4', 4);
                put('5', 5);
                put('6', 6);
                put('7', 7);
                put('8', 8);
                put('9', 9);
    }};

    public static void main(String[] args) {

        // test case 1
        String input = "";
        process(input);

        // test case 2
        input = null;
        process(input);

        // test case 3
        input = "12345";
        process(input);

        // test case 4
        input = "-12345";
        process(input);

        // test case 5
        input = "123 45";
        process(input);

        // test case 6
        input = "123$45";
        process(input);

        // test case 7
        input = "2147483650";
        process(input);

        // test case 8
        input = "-2147483650";
        process(input);
    }

    // O(n) time O(n) space
    private static void process(String input) {

        if(input == null || input.isEmpty()) {
            System.out.println("Invalid input");
            return;
        }

        StringBuilder sb = new StringBuilder()
                .append("Integer of ").append(input)
                .append(": ")
                .append(toInteger(input));
        System.out.println(sb.toString());
    }

    private static int toInteger(String input) {

        if(input.charAt(0) == '-') {
            return -1 * toInteger(input.substring(1));
        }

        char[] inputArr = input.toCharArray();
        int result = 0;

        for(int i = 0; i < inputArr.length; ++i) {
            char digit = inputArr[i];
            if(integerMap.containsKey(digit)) {
                result *= 10;
                result += integerMap.get(digit);
            } else {
                return -1;
            }
        }

        // for long/ double values
        return (result + "").equalsIgnoreCase(input) ? result : -1;
    }

}
