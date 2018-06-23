package com.programcreek.algorithms.string;

import java.util.HashMap;

public class IsomorphicStrings {

    public static void main(String[] args) {

        // test case 1
        String input1 = "eggling";
        String input2 = "addestd";
        process(input1, input2);

        // test case 2
        String input3 = "teggling";
        String input4 = "addestd";
        process(input3, input4);

        // test case 3
        String input5 = "foo";
        String input6 = "bar";
        process(input5, input6);

        // test case 4
        String input7 = "";
        String input8 = "";
        process(input7, input8);

        // test case 5
        String input9 = null;
        String input10 = "addestd";
        process(input9, input10);

    }

    // O(n) time O(n) space
    private static void process(String input1, String input2) {

        StringBuilder sb = new StringBuilder()
                .append("Are ").append(input1)
                .append(" and ").append(input2)
                .append(" isomorphic ").append(areIsomorphic(input1, input2));
        System.out.println(sb.toString());
    }

    private static boolean areIsomorphic(String input1, String input2) {

        if(input1 == null || input2 == null || input1.length() != input2.length()) {
            return false;
        }

        HashMap<Character, Character> charMappings = new HashMap<Character, Character>();
        char[] inputArr1 = input1.toCharArray();
        char[] inputArr2 = input2.toCharArray();

        for(int i = 0; i < inputArr1.length; ++i) {
            char char1 = inputArr1[i];
            char char2 = inputArr2[i];

            if(!charMappings.containsKey(char1)) {
                charMappings.put(char1, char2);
            } else {
                char mappedChar = charMappings.get(char1);
                if(mappedChar != char2) {
                    return false;
                }
            }
        }

        return true;
    }
}

