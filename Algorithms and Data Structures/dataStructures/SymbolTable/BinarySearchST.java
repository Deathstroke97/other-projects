package com.example.packages.dataStructures.SymbolTable;

import com.example.packages.stdlib.In;
import java.util.*;
import com.example.packages.dataStructures.queue.QueueLinkedListImplementation;

public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int rank(Key key, int low, int high) {
        if (high < low)
            return low;
        int middle = low + (high - low) / 2;
        int cmp = key.compareTo(keys[middle]);
        if (cmp < 0)
            return rank(key, low, middle - 1);
        else if(cmp > 0)
            return rank(key, low + 1, high);
        else return middle;

    }

    public Value get(Key key) {
        if (isEmpty())
            return null;
        int i = rank(key, 0, 4);
        if (i < N && keys[i].compareTo(key) == 0)
            return vals[i];
        return null;
    }

    public void put(Key key, Value val) {
        if(N == keys.length / 2){
            Key[] newKeys = (Key[])new Comparable[keys.length * 2];
            for(int i = 0; i  < N; i++)
                newKeys[i] = keys[i];
            keys = newKeys;
        }
        int i = rank(key, 0, N - 1);
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }
/*    public Key delete(Key key) {

    }*/
    public Key ceiling(Key key) {
        int i = rank(key, 0, N - 1);
        return keys[i];

    }
    public Iterable<Key> keys() {
        QueueLinkedListImplementation queue = new QueueLinkedListImplementation();
        for (int i = 0; i < N; i++) {
            queue.enqueue(keys[i]);
        }
        return queue;
    }


}


class exampleWithClass {
    public static void main(String[] args) {
        BinarySearchST<String, Integer> st = new BinarySearchST<>(7);

        st.put("Saule", 0);
        st.put("Azat", 1);
        st.put("Bibo", 2);
        st.put("Askar", 3);
        for(String key : st.keys()){
            System.out.println(key + " : "+ st.get(key));
        }
        System.out.println(st.ceiling("Almas"));
        st.put("Almas", 4);
        System.out.println("after ");
        for(String key : st.keys()){
            System.out.println(key + " : "+ st.get(key));
        }
        System.out.println(st.ceiling("Almas"));
    }
}

