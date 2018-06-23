package com.programcreek.algorithms.array;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author ptathavadkar
 */
public class IntervalOperations {

    private static IntervalComparator intervalComparator = new IntervalComparator();

    public static void main(String[] args) {

        // test case 1
        ArrayList<Interval> intervals = new ArrayList<Interval>() {{
            add(new Interval(1, 3));
            add(new Interval(2, 6));
            add(new Interval(3, 14));
            add(new Interval(15, 18));
            add(new Interval(-1, 2));
        }};
        merge(intervals);

        // test case 2
        intervals = null;
        merge(intervals);

        // test case 3
        intervals = new ArrayList<Interval>() {{
            add(new Interval(1, 3));
            add(new Interval(4, 5));
            add(new Interval(6, 7));
            add(new Interval(8, 9));
        }};
        merge(intervals);

        // test case 4
        intervals = new ArrayList<Interval>() {{
            add(new Interval(1, 3));
            add(new Interval(3, 4));
            add(new Interval(4, 5));
            add(new Interval(5, 6));
            add(new Interval(6, 8));
        }};
        merge(intervals);

        // test case 5
        intervals = new ArrayList<Interval>() {{
            add(new Interval(1, 3));
            add(new Interval(1, 4));
            add(new Interval(4, 5));
            add(new Interval(1, 6));
            add(new Interval(6, 8));
        }};
        merge(intervals);

        // test case 6
        intervals = new ArrayList<Interval>() {{
            add(new Interval(1, 3));
            add(new Interval(1, 4));
            add(new Interval(4, 5));
            add(new Interval(1, 6));
            add(new Interval(6, 8));
        }};
        insert(intervals, null);

        // test case 7
        insert(null, null);

        // test case 8
        intervals = new ArrayList<Interval>() {{
            add(new Interval(1, 2));
            add(new Interval(3, 5));
            add(new Interval(6, 7));
            add(new Interval(8, 10));
            add(new Interval(12, 16));
        }};

        insert(intervals, new Interval(4,9));
    }

    // O(nlogn) time O(n) space 
    private static void insert(ArrayList<Interval> intervals, Interval newInterval) {

        // validate
        if(intervals == null || newInterval == null) {
            System.out.println("Invalid input");
            return;
        }

        // insert and merge intervals
        intervals.add(newInterval);
        merge(intervals);

    }

    // O(nlogn) time O(n) space
    private static void merge(ArrayList<Interval> intervals) {

        // validate
        if (intervals == null || intervals.size() == 0) {
            System.out.println("Invalid input");
            return;
        }

        // merge intervals
        ArrayList<Interval> mergedIntervals = mergeIntervals(intervals);

        // print
        for (Interval interval : mergedIntervals) {
            System.out.print(interval);
        }
        System.out.println();
    }

    private static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervals) {

        PriorityQueue<Interval> orderedIntervals = new PriorityQueue<Interval>(intervals.size(),
                intervalComparator);
        ArrayList<Interval> result = new ArrayList<Interval>();
        orderedIntervals.addAll(intervals);

        while (orderedIntervals.size() > 0){
            Interval first = orderedIntervals.poll();
            Interval second = orderedIntervals.poll();

            // no more comparisons left
            if(second == null) {
                result.add(first);
                break;
            }

            // if merging possible
            if (first.end >= second.start) {
                Interval merged = new Interval(first.start, Math.max(first.end, second.end));
                orderedIntervals.add(merged);
            } else {
                result.add(first);
                orderedIntervals.add(second);
            }
        }

        return result;
    }
}
