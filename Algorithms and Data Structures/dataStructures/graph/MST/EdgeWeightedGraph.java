package com.example.packages.dataStructures.graph.MST;
import com.example.packages.dataStructures.linkedList.buildLinkedList.LinkedList;
//import com.example.packages.dataStructures.linkedList.LinkedList;
import com.example.packages.stdlib.*;
import java.util.*;
import java.io.*;

public class EdgeWeightedGraph{
    private static final String NEWLINE = System.getProperty("line.separator");
    private final int V;
    private int E;
    private LinkedList<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (LinkedList<Edge>[]) new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public EdgeWeightedGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            Edge edge = new Edge(v, w, weight);
            addEdge(edge);
        }
    }
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].prepend(e);
        adj[w].prepend(e);
        E++;
    }

    public int V() {
        return V;
    }
    public int E() {
        return E;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {
        ArrayList<Edge> listOfEdges = new ArrayList<>();
        for (int v = 0; v < V; v++) {
            for (Edge e : adj[v]) {
                if (e.other(v) > v) {
                    listOfEdges.add(e);
                }
            }
        }
        return listOfEdges;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (Edge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Aзат\\IdeaProjects\\exercises" +
                "\\src\\com\\example\\packages\\dataStructures\\graph\\MST\\tinyEWG.txt");             // create a File object
        EdgeWeightedGraph graph = new EdgeWeightedGraph(new In(file));
        System.out.println(graph.toString());
    }

}
