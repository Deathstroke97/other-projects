package com.example.packages.exercises.Leetcode.sorting;
import java.util.*;
import java.util.LinkedList;

import com.example.packages.exercises.Leetcode.sorting.Interval;

public class mergeIntervalsGraphSolution {
    private Map<Interval, List<Interval> > graph;
    private Map<Integer, List<Interval> > nodesInComp;
    private Set<Interval> visited;

    private boolean overlap(Interval a, Interval b) {
        return a.start <= b.end && b.start <= a.end;
    }

    private void buildGraph(List<Interval> intervals) {
        graph = new HashMap<>();
        for (Interval interval : intervals) {
            graph.put(interval, new LinkedList<>());
        }
        for (Interval interval1 : intervals) {
            for (Interval interval2 : intervals) {
                if (overlap(interval1, interval2)) {
                    graph.get(interval1).add(interval2);
                    graph.get(interval2).add(interval1);
                }
            }
        }
    }

    private Interval mergeNodes(List<Interval> nodes) {
        int minStart = nodes.get(0).start;
        for (Interval node : nodes) {
            minStart = Math.min(minStart, node.start);
        }

        int maxEnd = nodes.get(0).end;
        for (Interval node : nodes) {
            maxEnd = Math.max(maxEnd, node.end);
        }

        return new Interval(minStart, maxEnd);
    }

    private void markComponent(Map<Interval, List<Interval>> graph, int comNumber) {
        for (Interval interval : graph.keySet()) {
            if (!visited.contains(interval)) {
                markComponentDFS(interval, comNumber);
                comNumber++;
            }
        }
    }

    private void markComponentDFS(Interval start, int compNumber) {
        visited.add(start);
        if (!nodesInComp.containsKey(compNumber)) {
            nodesInComp.put(compNumber, new LinkedList<>());
        }
        nodesInComp.get(compNumber).add(start);
        for (Interval child : graph.get(start)) {
            if (!visited.contains(child)) {
                markComponentDFS(child, compNumber);
            }
        }
    }

    private void markComponentDFSOrigin(Interval start, int compNumber) {
        Stack<Interval> stack = new Stack<>();
        stack.add(start);

        while(!stack.isEmpty()) {
            Interval node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(node);

                if (nodesInComp.get(compNumber) == null) {
                    nodesInComp.put(compNumber, new LinkedList<>());
                }
                nodesInComp.get(compNumber).add(node);

                for (Interval child : graph.get(node)) {
                    stack.add(child);
                }
            }
        }
    }

    private void buildComponents(List<Interval> intervals) {
        nodesInComp = new HashMap<>();
        visited = new HashSet<>();
        int compNumber = 0;

        for (Interval interval : intervals) {
            if (!visited.contains(interval)) {
                markComponentDFS(interval, compNumber);
                compNumber++;
            }
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        buildGraph(intervals);
        buildComponents(intervals);

        List<Interval> merged = new LinkedList<>();
        for (int comp = 0; comp < nodesInComp.size(); comp++) {
            merged.add(mergeNodes(nodesInComp.get(comp)));
        }
        return merged;
    }

}
