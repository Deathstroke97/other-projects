package com.example.packages.dataStructures.graph.directed;
import com.example.packages.stdlib.*;
import java.io.*;
import java.util.ArrayList;

public class KosarajuSCC {
    private boolean[] marked;
    private int[] id;
    private int count;
    private Digraph G;
    ArrayList<Integer>[] list;

    public KosarajuSCC(Digraph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        this.G = G;

        DepthFirstOrder order = new DepthFirstOrder(G.reverse());
        for (int s : order.reversePostOrder()) {
            if(!marked[s]){
                dfs(G, s);
                count++;
            }
        }
        list  = new ArrayList[count];
        for (int i = 0; i < count; i++) {
            list[i] = new ArrayList<Integer>();
        }

    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v))
            if(!marked[w])
                dfs(G, w);
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {return count;}

    public void show() {
        for(int v = 0; v < G.V(); v++) {
            list[id[v]].add(v);
        }
        for(ArrayList i : list) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Aзат\\IdeaProjects\\exercises" +
                "\\src\\com\\example\\packages\\dataStructures\\graph\\directed\\tinyDG.txt");
        Digraph G = new Digraph(new In(file));
        KosarajuSCC scc = new KosarajuSCC(G);
        scc.show();
    }
}
