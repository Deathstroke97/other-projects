package com.example.packages.dataStructures.graph.MST;
import com.example.packages.dataStructures.queue.QueueLinkedListImplementation;
import com.example.packages.dataStructures.priorityQueue.MinPQ;
import com.example.packages.stdlib.*;
import java.util.*;
import java.io.*;

public class LazyPrimMST {
    private boolean[] marked;
    private QueueLinkedListImplementation<Edge> mst;
    private MinPQ<Edge> pq;
    private double weight;

    public LazyPrimMST(EdgeWeightedGraph G) {
        pq = new MinPQ<>(G.E());
        marked = new boolean[G.V()];
        mst = new QueueLinkedListImplementation<>();
        visit(G, 0);

        while(!pq.isEmpty()) {
            Edge e = pq.deleteMin();
            int v = e.either();
            int w = e.other(v);

            if (marked[v] && marked[w]) continue;
            mst.enqueue(e);
            weight += e.weight();
            if (!marked[v]) visit(G, v);
            if (!marked[w]) visit(G, w);
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v))
            if(!marked[e.other(v)])
                pq.insert(e);
    }

    public Iterable<Edge> edges(){
        return mst;
    }
    public double weight() {
        return weight;
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Aзат\\IdeaProjects\\exercises" +
                "\\src\\com\\example\\packages\\dataStructures\\graph\\MST\\tinyEWG.txt");             // create a File object
        EdgeWeightedGraph graph = new EdgeWeightedGraph(new In(file));

        LazyPrimMST mst = new LazyPrimMST(graph);

        for (Edge e : mst.edges()) {
            System.out.print(e + "\n");
        }
        System.out.println("weight of MST: " + mst.weight());
    }
}
