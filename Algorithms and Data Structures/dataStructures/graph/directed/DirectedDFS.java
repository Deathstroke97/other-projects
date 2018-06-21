package com.example.packages.dataStructures.graph.directed;
import com.example.packages.stdlib.*;
import java.util.*;
import java.io.*;



public class DirectedDFS {
    private boolean[] marked;

    public DirectedDFS(Digraph G, Iterable<Integer> sources) {
        this.marked = new boolean[G.V()];
        for (int s : sources ) {
            if(!marked[s]){
                dfs(G, s);
            }
        }
    }

    public DirectedDFS(Digraph G, int s) {
        this.marked = new boolean[G.V()];
        dfs(G, s);
    }

    public void dfs(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if(!marked[w])
                dfs(G, w);
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Aзат\\IdeaProjects\\exercises" +
                "\\src\\com\\example\\packages\\dataStructures\\graph\\directed\\tinyDG.txt");
        Digraph G = new Digraph(new In(file));
        DirectedDFS reachable = new DirectedDFS(G, 2);
        for (int v = 0; v < G.V(); v++) {
            if(reachable.marked[v]){
                System.out.print(v + " " );
            }
        }
    }

}
