package com.example.packages.exercises.Leetcode.sorting;
import java.util.*;
import java.util.LinkedList;


class Interval {
    int start;
    int end;
    Interval() {
        start = 0;
        end = 0;
    }
    Interval(int s, int e) {
        start = s;
        end = e;
    }
    @Override
    public String toString() {
        return "[" + start + "," + end + "]";
    }
}


public class mergeIntervals {

    private static class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());

        java.util.LinkedList<Interval> merged = new LinkedList<>();
        for (Interval interval : intervals) {
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            else{
                merged.getLast().end = Math.max(interval.end, merged.getLast().end);
            }
        }
        return merged;
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        Interval first = new Interval(2, 3);
        Interval second = new Interval(5, 5);
        Interval third = new Interval(2, 2);
        Interval fourth = new Interval(3, 4);
        Interval fifth = new Interval(3, 4);

        list.add(first);
        list.add(second);
        list.add(third);
        list.add(fourth);
        list.add(fifth);

        List<Interval> result = merge(list);

        for (Interval interval : result) {
            System.out.print(interval);
        }
    }
}