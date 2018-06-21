package com.example.packages.dataStructures.graph.undirected;

public class TwoColor {
    boolean[] marked;
    boolean bipartite = true;
    int[] colors;
    TwoColor(Graph G) {
        marked = new boolean[G.V()];
        colors = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            colors[i] = -1;
        }
        colors[0] = 1;
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]){
                dfs(G, s);
            }
        }
    }
    public void dfs(Graph G, int s) {
        marked[s] = true;
        for (int v : G.adj(s)) {
            if(!marked[v]){
                marked[v] = true;
                colors[v] = 1 - colors[s];
                dfs(G, v);
            }
            else if(colors[v] == colors[s]){
                bipartite = false;
            }
        }
    }
    public boolean isBipartite() {
        return bipartite;
    }
}
