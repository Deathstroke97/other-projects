package com.example.packages.dataStructures.graph.directed;
import com.example.packages.dataStructures.stack.StackArrayImplementation;
import com.example.packages.stdlib.*;
import java.io.*;

public class DepthFirstDirectedPaths {
    private final int V;
    private boolean[] marked;
    private int[] parent;
    private final int s;
    DepthFirstDirectedPaths(Digraph G, int s) {
        this.s = s;
        this.V = G.V();
        parent = new int[G.V()];
        marked = new boolean[G.V()];
        for (int v = s; v < G.V(); v++)
            if(!marked[v])
                dfs(G, s);

    }

    public void dfs(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)){
            if(!marked[w]){
                parent[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    StackArrayImplementation<Integer> path(int v) {
        if(!hasPathTo(v)) return null;
        StackArrayImplementation<Integer> path = new StackArrayImplementation();
        for (int x = v; x != s; x  = parent[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Aзат\\IdeaProjects\\exercises" +
                "\\src\\com\\example\\packages\\dataStructures\\graph\\directed\\tinyDG.txt");
        Digraph G = new Digraph(new In(file));
        DepthFirstDirectedPaths dirPath = new DepthFirstDirectedPaths(G, 0);

        StackArrayImplementation<Integer> stack;
        stack = dirPath.path(3);
        for(int i : stack) {
            System.out.print(i + "->");
        }
    }



}
