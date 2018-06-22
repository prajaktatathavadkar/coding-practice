package com.programcreek.algorithms.array;

public class RotateArray {

    public static void main(String args[]) {

        // test case 1
        int[] input1 = {1,2,3,4,5,6,7};
        int k = 3;
        processWithSpace(input1, k);

        // test case 2
        int[] input2 = {1,2,3,4,5,6,7};
        k = 0;
        processWithSpace(input2, k);

        // test case 3
        int[] input3 = {};
        k = 2;
        processWithSpace(input3, k);

        // test case 4
        int[] input4 = null;
        k = 2;
        processWithSpace(input4, k);

        // test case 5
        int[] input5 = {15, -1, 4, 5, 1};
        k = 5;
        processWithSpace(input5, k);

        // test case 6
        int[] input6 = {15, -1, 4, 5, 1};
        k = -5;
        processWithSpace(input6, k);
    }

    // O(n) time O(n) space
    private static void processWithSpace(int[] input, int k) {

        if(input ==  null || k < 0) {
            System.out.println("Invalid input");
            return;
        }

        // compute the result
        int[] rotatedInput = rotate(input, k);

        // print the result
        print(rotatedInput);
    }

    private static int[] rotate(int[] input, int k) {

        int n = input.length;
        int[] rotatedArr = new int[n];

        for(int i = 0; i < n; ++i) {
            rotatedArr[(i + k) % n] = input[i];
        }
        return rotatedArr;
    }

    private static void print(int[] input) {

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < input.length; ++i) {
            sb.append(input[i] + " ");
        }

        System.out.println("Rotated array: " + sb.toString());
    }
}
