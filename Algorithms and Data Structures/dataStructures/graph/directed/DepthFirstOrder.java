package com.example.packages.dataStructures.graph.directed;
import com.example.packages.dataStructures.stack.StackArrayImplementation;
import java.io.*;
import com.example.packages.stdlib.*;
import com.example.packages.dataStructures.queue.QueueLinkedListImplementation;

public class DepthFirstOrder {
    private boolean[] marked;

    QueueLinkedListImplementation<Integer> preOrder = new QueueLinkedListImplementation<>();
    QueueLinkedListImplementation<Integer> postOrder = new QueueLinkedListImplementation<>();
    StackArrayImplementation<Integer> reversePostOrder = new StackArrayImplementation<>();

    DepthFirstOrder(Digraph G) {
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if(!marked[v]) {
                dfs(G, v);
            }
        }
    }
    public void dfs(Digraph G, int v) {
        marked[v] = true;
        preOrder.enqueue(v);
        for (int w : G.adj(v)) {
            if(!marked[w]){
                dfs(G, w);
            }
        }
        postOrder.enqueue(v);
        reversePostOrder.push(v);
    }
    public Iterable<Integer> preOrder() {
        return preOrder;
    }

    public Iterable<Integer> postOrder() {
        return postOrder;
    }

    public Iterable<Integer> reversePostOrder() {
        return reversePostOrder;
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Aзат\\IdeaProjects\\exercises" +
                "\\src\\com\\example\\packages\\dataStructures\\graph\\directed\\tinyDG.txt");
        Digraph G = new Digraph(new In(file));
        DepthFirstOrder dfo = new DepthFirstOrder(G);

        System.out.print("PostOrder: ");
        for(int i : dfo.postOrder()) {
            System.out.print(i + " ");
        }
        System.out.print("\n");

        System.out.print("PreOrder: ");
        for(int i : dfo.preOrder()) {
            System.out.print(i + " ");
        }
        System.out.print("\n");

        System.out.print("ReversePostOrder: ");
        for(int i : dfo.reversePostOrder) {
            System.out.print(i + " ");
        }
        System.out.print("\n");

    }
}
