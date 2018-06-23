package com.programcreek.algorithms.array;

import java.util.Comparator;

/**
 * @author ptathavadkar
 */
public class IntervalComparator implements Comparator<Interval> {

    @Override
    public int compare(Interval i1, Interval i2) {
        return i1.start - i2.start;
    }
}
