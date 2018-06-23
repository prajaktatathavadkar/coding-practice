package com.programcreek.algorithms.array;

import java.util.Comparator;

/**
 * @author ptathavadkar
 */
public class MaximumIntComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer int1, Integer int2) {
        if(int1 > int2) {
            return 1;
        } else if(int1 < int2) {
            return -1;
        }

        return 0;
    }
}
