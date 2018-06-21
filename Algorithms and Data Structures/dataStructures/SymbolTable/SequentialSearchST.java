package com.example.packages.dataStructures.SymbolTable;

import java.util.Iterator;
import java.util.Queue;
import com.example.packages.dataStructures.queue.*;
import com.example.packages.stdlib.*;
import java.util.*;

public class SequentialSearchST<Key, Value> {
    private Node first;
    private int N;

    private class Node {
        Key key;
        Value val;
        Node next;
        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
                return x.val;
        return null;
    }

    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        N++;
    }

    public boolean contains(Key key) {
        for (Node x = first; x != null; x = x.next)
            if(x.key.equals(key))
                return true;
        return false;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public Node delete(Key key) {
        Node deleted = null;
        for (Node x = first; x != null; x = x.next) {
            Node next = x.next;
            if (next.key.equals(key)){
                deleted = next;
                x.next = x.next.next;
            }
        }
        N--;
        return deleted;
    }

    public Iterable<Key> keys() {
        QueueLinkedListImplementation<Key> q = new QueueLinkedListImplementation<Key>();
            for (Node x = first; x != null; x = x.next) {
                q.enqueue(x.key);
            }
        return q;
    }
}

class example {
    public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<>();
        Scanner scanner = new Scanner(System.in);
        int i = 0;

        String[] splitted = scanner.nextLine().split(" ");
        for(int j = 0; j < splitted.length; j++) {
            st.put(splitted[j], i );
            i++;
        }
        st.delete(splitted[0]);
        System.out.println(st.size());
        for (String s : st.keys()){
            System.out.println(s + " "  + st.get(s));
        }
    }
}