package com.example.packages.dataStructures.graph.undirected;
import com.example.packages.dataStructures.queue.QueueLinkedListImplementation;
import com.example.packages.dataStructures.stack.StackLinkedListImplementation;

public class BreadthFirstSearch {

    private boolean[] marked;
    private int[] parent;
    private final int s;

    public BreadthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        parent = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    public void bfs(Graph G, int s) {
        QueueLinkedListImplementation<Integer> queue =  new QueueLinkedListImplementation<>();
        marked[s] = true;
        queue.enqueue(s);
        while(!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : G.adj(v)){
                if (!marked[w]){
                    marked[w] = true;
                    parent[w] = v;
                    queue.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public StackLinkedListImplementation<Integer> pathTo(int v) {
        if(!hasPathTo(v)) {return null;}

        StackLinkedListImplementation<Integer> path = new StackLinkedListImplementation<>();
        for (int w = v; w != s; w = parent[w]) {
            path.push(w);
        }
        path.push(s);
        return path;
    }




}
