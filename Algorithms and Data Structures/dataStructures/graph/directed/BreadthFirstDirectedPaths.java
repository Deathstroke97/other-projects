package com.example.packages.dataStructures.graph.directed;
import com.example.packages.dataStructures.queue.QueueLinkedListImplementation;
import com.example.packages.stdlib.In;
import com.example.packages.dataStructures.stack.StackArrayImplementation;
import com.example.packages.stdlib.*;
import java.io.*;

public class BreadthFirstDirectedPaths {
    boolean[] marked;
    private int V;
    int[] parent;
    private final int s;

    BreadthFirstDirectedPaths(Digraph G, int s) {
        this.marked = new boolean[G.V()];
        this.V = V;
        this.s = s;
        parent = new int[G.V()];
        bfs(G,  s);
    }

    public void bfs(Digraph G, int v) {
        QueueLinkedListImplementation<Integer> queue = new QueueLinkedListImplementation();
         queue.enqueue(v);
         while(!queue.isEmpty()) {
             int w = queue.dequeue();
             for (int y : G.adj(w))
                 if(!marked[y]){
                     marked[y] = true;
                     parent[y] = w;
                     queue.enqueue(y);
                 }
         }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    StackArrayImplementation<Integer> path(int v) {
        if(!hasPathTo(v)) return null;
        StackArrayImplementation<Integer> path = new StackArrayImplementation();
        for (int x = v; x != s; x  = parent[x])
            path.push(x);
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Aзат\\IdeaProjects\\exercises" +
                "\\src\\com\\example\\packages\\dataStructures\\graph\\directed\\tinyDG.txt");
        Digraph G = new Digraph(new In(file));
        BreadthFirstDirectedPaths breathPath = new BreadthFirstDirectedPaths(G, 0);

        StackArrayImplementation<Integer> stack;
        stack = breathPath.path(3);
        for(int i : stack)
            System.out.print(i + "->");

    }
}
