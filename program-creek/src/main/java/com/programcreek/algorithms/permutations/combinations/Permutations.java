package com.programcreek.algorithms.permutations.combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ptathavadkar
 */
public class Permutations {

    public static void main(String[] args) {

        // test case 1
        int[] input1 = {1, 2, 3};
        process(input1);

        // test case 2
        int[] input2 = {1, 1, 2, 3};
        process(input2);

        // test case 2
        int[] input3 = {2, 1, 3};
        Arrays.sort(input3);
        process(input3);
    }

    private static void process(int[] input) {

        LinkedList<Integer> result = new LinkedList<Integer>();
        LinkedList<Integer> inputList = new LinkedList<Integer>();
        populate(inputList, input);
        System.out.println("PERMUTATIONS: ");
        permute(inputList, result);
    }

    private static void permute(LinkedList<Integer> input, LinkedList<Integer> result) {

        if (input.size() == 0) {
            print(result);
        }

        for (int i = 0; i < input.size(); ++i) {
            int num = input.remove(i);
            result.addLast(num);
            permute(input, result);
            input.add(i, num);
            result.removeLast();
        }

    }

    private static void populate(LinkedList<Integer> inputList, int[] input) {

        for (int i : input) {
            inputList.add(i);
        }
    }

    private static void print(LinkedList<Integer> linkedList) {

        for (int num : linkedList) {
            System.out.print(num + "");
        }
        System.out.println();
    }
}
