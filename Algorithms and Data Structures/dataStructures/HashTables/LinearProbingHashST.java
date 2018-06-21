package com.example.packages.dataStructures.HashTables;

import com.example.packages.dataStructures.queue.QueueLinkedListImplementation;

public class LinearProbingHashST<Key, Value> {
    private int N;
    private int M = 16;
    private Key[] keys;
    private Value[] vals;

    LinearProbingHashST(int newCap) {
        M = newCap;
        keys = (Key[])new Object[M];
        vals = (Value[]) new Object[M];
    }

    public int hash(Key key) {
        return (key.hashCode() & 0xfffffff) % M;
    }

    public void resize(int newCap) {
        LinearProbingHashST<Key, Value> t = new LinearProbingHashST<>(newCap);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null)
                t.put(keys[i], vals[i]);
        }
        keys = t.keys;
        vals = t.vals;
    }

    public void put(Key key, Value val) {
        if (N >= M/2) resize(2 * M);
        int i;
        for( i = hash(key); keys[i] != null; i = (i + 1) % M){
            if(keys[i].equals(key)){
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key) {
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }

    public void delete(Key key) {
        if(!contains(key)) return;
        int i = hash(key);
        while(!keys[i].equals(key)){
            i = (i + 1) % M;
        }
        keys[i] = null;
        vals[i] = null;
        N--;
        i = (i + 1) % M;
        while(keys[i] == null){
            Key k = keys[i];
            Value v = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(k, v);
            i = (i + 1) % M;
        }
        if(N > 0 && N == M / 8)
            resize(M / 2);
    }

    public boolean contains(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if(keys[i].equals(key)){
                return true;
            }
        }
        return false;
    }
    public Iterable<Key> keys() {
        QueueLinkedListImplementation<Key> queue = new QueueLinkedListImplementation<>();
        for (int i = 0; i < M; i++) {
            if(keys[i] != null){
                queue.enqueue(keys[i]);
            }
        }
        return queue;
    }
 }
