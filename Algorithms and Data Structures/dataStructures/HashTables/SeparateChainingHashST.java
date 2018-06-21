package com.example.packages.dataStructures.HashTables;
import com.example.packages.dataStructures.SymbolTable.SequentialSearchST;
import com.example.packages.dataStructures.queue.QueueLinkedListImplementation;

public class SeparateChainingHashST<Key, Value> {

    private int N;
    private int M;
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(997);
    }
    public SeparateChainingHashST(int M) {
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++)
            st[i] = new SequentialSearchST<>();
    }
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    public Value get(Key key) {
        return  st[hash(key)].get(key);
    }
    public void put(Key key, Value val) {
        st[hash(key)].put(key, val);
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public Iterable<Key> keys() {
        QueueLinkedListImplementation<Key> queue  = new QueueLinkedListImplementation<>();
        for (int i = 0; i < M; i++) {
            for(Key key : st[i].keys()) {
                queue.enqueue(key);
            }
        }
        return queue;
    }

}
