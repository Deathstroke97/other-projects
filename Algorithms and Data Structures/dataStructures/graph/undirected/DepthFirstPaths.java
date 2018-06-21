package com.example.packages.dataStructures.graph.undirected;
import com.example.packages.dataStructures.stack.StackLinkedListImplementation;



public class DepthFirstPaths {

    private boolean[] marked;
    private int[] parent;
    private final int s;

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        parent = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            if (!marked[w]) {
                parent[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public StackLinkedListImplementation<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        StackLinkedListImplementation<Integer> path = new StackLinkedListImplementation<>();
        for (int x = v; x != s; x = parent[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
