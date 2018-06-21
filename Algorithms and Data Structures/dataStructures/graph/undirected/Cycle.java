package com.example.packages.dataStructures.graph.undirected;

public class Cycle  {
    boolean[] marked;
    boolean hasCycle;
    public Cycle(Graph G) {
        marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]){
                dfs(G, s, s);
            }
        }
    }
    public void dfs(Graph G, int v, int p) {
        for (int w : G.adj(v)){
            if(!marked[w]){
                dfs(G, w, v);
            }
            else if(w != p) hasCycle = true;
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
