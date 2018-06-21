package com.example.packages.dataStructures.graph.undirected;
import com.example.packages.stdlib.*;
import com.example.packages.dataStructures.HashTables.SeparateChainingHashST;
import com.example.packages.dataStructures.SymbolTable.SequentialSearchST;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

public class ConnectedComponents {
    private boolean[] marked;
    private int[] id;
    private int count;

    public ConnectedComponents(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)){
            if(!marked[w])
                dfs(G, w);
        }
    }
    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Aзат\\IdeaProjects\\exercises" +
                "\\src\\com\\example\\packages\\dataStructures\\graph\\graph.txt");             // create a File object
        Graph graph = new Graph(new In(file));

        ConnectedComponents cc = new ConnectedComponents(graph);
        ArrayList<Integer>[] components;
        components = (ArrayList<Integer>[]) new ArrayList[cc.count()];
        for (int i = 0; i < components.length; i++) {
            components[i] = new ArrayList<Integer>();
        }
        for (int v = 0; v < graph.V(); v++) {
            components[cc.id(v)].add(v);
        }
        System.out.println(Arrays.toString(components));



    }

}



















































































/*    private int count;
    SeparateChainingHashST<Integer, Integer> tableId;
    SeparateChainingHashST<Integer, Boolean> marked;

    public ConnectedComponents(Graph G) {
        tableId = new SeparateChainingHashST<>(G.V());
        marked = new SeparateChainingHashST<>(G.V());

        for (int s = 0; s < G.V(); s++) {
            if (!marked.get(s)) {
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked.put(v, true);
        tableId.put(count, v);
        for (Integer w : G.adj(v)){
            dfs(G, w);
        }
    }
    public boolean connected(int v, int w) {
        return tableId.get(v) == tableId.get(w);
    }

    public int id(int v) {
        return tableId.get(v);
    }

    public int count() {
        return count;
    }*/
