package com.example.packages.dataStructures.stack;
import java.util.*;
import com.example.packages.stdlib.*;


public class FixedCapacityStack<Item> {
    Item[] a;
    private int N;
    private int capacity;
    public FixedCapacityStack(int cap) {
        a = (Item[])new Object[cap];
        capacity = cap;
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }
    public void push(Item item) {
        a[N++] = item;
    }
    public Item pop() {
        return a[--N];
    }
    public boolean isFull() {
        return N == capacity;
    }
}
class example {
    public static void main(String[] args) {
        FixedCapacityStack<String> s;
        s = new FixedCapacityStack<String>(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
