package com.example.packages.dataStructures.graph.directed;
import com.example.packages.dataStructures.stack.StackArrayImplementation;
import java.io.*;
import com.example.packages.stdlib.*;

public class DirectedCycle {
    private int[] parent;
    private boolean[] marked;
    private StackArrayImplementation<Integer> cycle;
    private boolean[] onStack;

    public DirectedCycle(Digraph G) {
        parent = new int[G.V()];
        onStack = new boolean[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if(!marked[v])
                dfs(G, v);
        }
    }
    public void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if(this.hasCycle()) return;
            else if(!marked[w]) {
                parent[w] = v;
                dfs(G, w);
            }
            else if(onStack[w]) {
                cycle = new StackArrayImplementation<>();
                for (int x = v; x != w; x = parent[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;

    }
    public boolean hasCycle() {
        return cycle != null;
    }
    public Iterable<Integer> cycle() {
        return cycle;
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Aзат\\IdeaProjects\\exercises" +
                "\\src\\com\\example\\packages\\dataStructures\\graph\\directed\\tinyDG.txt");
        Digraph G = new Digraph(new In(file));
        DirectedCycle directedCycle = new DirectedCycle(G);
        for (int i : directedCycle.cycle()) {
            System.out.print(i + " ");
        }
    }

}
