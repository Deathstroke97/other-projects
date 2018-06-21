package com.example.packages.dataStructures.graph.directed;
import com.example.packages.dataStructures.linkedList.buildLinkedList.LinkedList;
import com.example.packages.stdlib.*;
import java.io.*;
import com.example.packages.dataStructures.graph.undirected.Graph;

public class Digraph  {
    private final int V;
    private int E;

    LinkedList<Integer>[] adj;

    public Digraph(int V) {
        adj = (LinkedList<Integer>[])new LinkedList[V];
        this.V = V;
        for (int v = 0; v < V; v++) {
           adj[v] = new LinkedList<>();
        }

    }

    public Digraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public void addEdge(int v, int w) {
        adj[v].prepend(w);
        E++;
    }

    public LinkedList<Integer> adj(int v) {
        return adj[v];
    }
    public int V() {
        return V;
    }
    public int E() {
        return E;
    }

    public void printGraph() {
        for (int v = 0; v < V; v++) {
            System.out.println("Adjacency list of vertex "+ v);
            System.out.println("head");
            for (Integer i : adj[v]) {
                System.out.print("->" + i);
            }
            System.out.println("\n");
        }
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj[v]) {
                R.addEdge(w, v);
            }
        }
        return R;
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Aзат\\IdeaProjects\\exercises" +
                "\\src\\com\\example\\packages\\dataStructures\\graph\\directed\\tinyDG.txt");
        Digraph G = new Digraph(new In(file));
        G.printGraph();

    }


}
