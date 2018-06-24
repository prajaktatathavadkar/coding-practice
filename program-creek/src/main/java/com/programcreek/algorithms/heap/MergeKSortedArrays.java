package com.programcreek.algorithms.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author ptathavadkar
 */
public class MergeKSortedArrays {

    public static void main(String[] args) {

        // test case 1
        ArrayList<Integer> input1 = new ArrayList<Integer>(){{add(1);add(2);add(3);add(4);
            add(5);add(6);add(7);add(8);}};
        ArrayList<Integer> input2 = new ArrayList<Integer>(){{add(-2);add(-1);add(0);add(1);
            add(2);add(3);}};
        ArrayList<Integer> input3 = new ArrayList<Integer>(){{add(-15);add(3);add(6);add(7);
            add(8);add(9);add(10);add(15);}};
        ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
        input.add(input1);
        input.add(input2);
        input.add(input3);
        process(input);

        // test case 2
        process(null);

        // test case 3
        process(new ArrayList<ArrayList<Integer>>());
    }

    public static void process(ArrayList<ArrayList<Integer>> input) {

        if(input == null || input.size() == 0) {
            System.out.println("Invalid input");
            return;
        }

        ArrayList<Integer> mergedSortedList = mergeSortedList(input);

        System.out.println(mergedSortedList);
    }

    private static ArrayList<Integer> mergeSortedList(ArrayList<ArrayList<Integer>> input) {

        ArrayList<Integer> mergedSortedList = new ArrayList<Integer>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();

        for(ArrayList<Integer> list : input) {
            for(Integer val : list) {
                priorityQueue.add(val);
            }
        }

        while (priorityQueue.size() > 0) {
            mergedSortedList.add(priorityQueue.poll());
        }

        return mergedSortedList;
    }

}
