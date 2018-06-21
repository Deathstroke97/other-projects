package com.example.packages.exercises.Leetcode.sorting;
import com.example.packages.exercises.Leetcode.sorting.Interval;
import java.util.*;
import java.util.LinkedList;

public class InsertInterval {

    public static int binarySearch(List<Interval> intervals, Interval newInterval, int low, int high) {
        int middle = (low + high) /2;
        if (low > high) {
            return low;
        }
        if (intervals.get(middle).start == newInterval.start) {
            return middle;
        }
        else if (intervals.get(middle).start > newInterval.start) {
            return binarySearch( intervals, newInterval, low, middle - 1);
        }
        else{
            return binarySearch( intervals, newInterval, middle + 1, high);
        }

    }
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int position = binarySearch( intervals, newInterval, 0, intervals.size() - 1);
        intervals.add(position, newInterval);
        LinkedList<Interval> merged = new LinkedList();
        for (Interval interval : intervals) {
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }
        return merged;
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        Interval first = new Interval(1, 2);
        Interval second = new Interval(3, 5);
        Interval third = new Interval(6, 7);
        Interval fourth = new Interval(8, 10);
        Interval fifth = new Interval(12, 16);

        Interval sixth = new Interval(4, 8);

        list.add(first);
        list.add(second);
        list.add(third);
        list.add(fourth);
        list.add(fifth);

        List<Interval> result = insert(list, sixth);

        for (Interval interval : result) {
            System.out.print(interval);
        }

    }
}
