package com.programcreek.algorithms.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author ptathavadkar
 */
public class DataStreamMedian {

    public static void main(String[] args) {

        // test case 1
        int[] input = {1,2,3,-4,-3,-2,-1,0};
        process(input);
    }

    private static void process(int[] input) {

        if(input == null || input.length <= 0) {
            System.out.println("Invalid input");
            return;
        }

        PriorityQueue<Integer> dataStreamLow = new PriorityQueue<Integer>();
        PriorityQueue<Integer> dataStreamHigh = new PriorityQueue<Integer>(1, Collections.reverseOrder());
        float currMedian = input[0];
        dataStreamHigh.add(input[0]);
        System.out.print(currMedian + " ");

        for(int i = 1; i < input.length; ++i) {
            currMedian = calculateMedian(dataStreamLow, dataStreamHigh, currMedian, input[i]);
            System.out.print(currMedian + " ");
        }

        System.out.println();
    }

    private static float calculateMedian(PriorityQueue<Integer> dataStreamLow, PriorityQueue<Integer> dataStreamHigh, float currMedian, int num) {

        if(num > currMedian) {
            dataStreamHigh.add(num);
        } else {
            dataStreamLow.add(num);
        }

        // even number of elements
        if ((dataStreamHigh.size() + dataStreamLow.size()) % 2 == 0) {

            if (dataStreamHigh.size() == dataStreamLow.size()) {
                return (dataStreamHigh.peek() + dataStreamLow.peek()) / 2f;
            } else if (dataStreamHigh.size() > dataStreamLow.size()) {
                int topElement = dataStreamHigh.poll();
                float result = (dataStreamHigh.peek() + topElement) / 2f;
                dataStreamHigh.add(topElement);
                return result;
            } else {
                int topElement = dataStreamLow.poll();
                float result = (dataStreamLow.peek() + topElement) / 2f;
                dataStreamLow.add(topElement);
                return result;
            }

        } else {

            if(dataStreamHigh.size() > dataStreamLow.size()) {
                return dataStreamHigh.peek();
            } else {
                return dataStreamLow.peek();
            }
        }
    }

}
