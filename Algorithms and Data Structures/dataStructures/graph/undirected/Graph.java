package com.example.packages.dataStructures.graph.undirected;
import com.example.packages.dataStructures.linkedList.buildLinkedList.LinkedList;
import com.example.packages.stdlib.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

public class Graph {

    private final int V;
    private int E;
    private LinkedList<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        adj = (LinkedList<Integer>[])new LinkedList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<Integer>();
    }

    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public int V() {return V;}
    public int E() {return E;}

    public LinkedList<Integer> adj(int v) {
        return adj[v];
    }

    public void addEdge(int v, int w) {
        adj[v].prepend(w);
        adj[w].prepend(v);
        E++;
    }

    public void printGraph() {
        for (int v = 0; v < V; v++) {
            System.out.println("Adjacency list of vertex "+ v);
            System.out.println("head");
            for (Integer i : adj[v])
                System.out.print("->" + i);
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Aзат\\IdeaProjects\\exercises" +
                "\\src\\com\\example\\packages\\dataStructures\\graph\\undirected\\graph.txt");             // create a File object
        Graph graph = new Graph(new In(file));
        graph.printGraph();
    }
}
