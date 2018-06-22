package com.programcreek.algorithms.string;

public class ReverseWords {

    public static void main(String args[]) {

        // test case 1
        String input1 = "The sky is blue";
        process(input1);

        // test case 2
        String input2 = null;
        process(input2);

        // test case 3
        String input3 = "";
        process(input3);

        // test case 4
        String input4 = "single";
        process(input4);
    }

    private static void process(String input) {

        if(input == null || input.isEmpty()) {
            return;
        }

        char[] inputArr = input.toCharArray();
        int start = 0;
        int end = inputArr.length - 1;

        // reverse string
        reverse(inputArr, start, end);

        // reverse words
        for(int i = 0; i < input.length(); ++i) {
            if(inputArr[i] == ' ') {
                end = i - 1;
                reverse(inputArr, start, end);
                start = i + 1;
            } else if(i == inputArr.length - 1) {
                end = i;
                reverse(inputArr, start, end);
            }
        }

        // print reverse
        System.out.println(inputArr);
    }

    private static void reverse(char[] inputArr, int start, int end) {

        for(int i = start, j = end; i < j; ++i, --j) {
            char temp = inputArr[i];
            inputArr[i] = inputArr[j];
            inputArr[j] = temp;
        }
    }

}
