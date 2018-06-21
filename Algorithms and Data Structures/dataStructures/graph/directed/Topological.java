package com.example.packages.dataStructures.graph.directed;

import com.example.packages.dataStructures.graph.undirected.Graph;
import com.example.packages.dataStructures.graph.undirected.SymbolGraph;
import com.example.packages.stdlib.*;
import java.io.*;


public class Topological {

    private Iterable<Integer> order;

    Topological(Digraph  G) {
        DirectedCycle cyclefinder = new DirectedCycle(G);
        if (!cyclefinder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePostOrder();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean isDAG() {
        return order != null;
    }


    public static void main(String[] args) {
        String fileName = "C:\\Users\\Aзат\\IdeaProjects\\exercises" +
                "\\src\\com\\example\\packages\\dataStructures\\graph\\directed\\jobs.txt";

        SymbolGraph sg = new SymbolGraph(fileName, "/");

        Topological top = new Topological(sg.DG());

        for(int v : top.order()){
          System.out.println(sg.name(v));
        }
    }
}

