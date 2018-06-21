package com.example.packages.dataStructures.queue;
import com.example.packages.stdlib.*;
import java.util.Iterator;



public class QueueLinkedListImplementation<Item> implements Iterable<Item>  {
    int N;
    public Node head;
    public Node tail;
    public Node current;


    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return N == 0;
    }
    public int size() {
        return N;
    }
    public boolean hasNext() {
       return current != null;
    }
    public Item next() {
        current = current.next;
        return current.item;
    }

    public void enqueue(Item item) {
        if(head == null) {
            head = new Node();
            head.item = item;
            head.next = null;
            tail = head;
        }
        else{
            Node oldLast = tail;
            tail = new Node();
            tail.item = item;
            tail.next = null;
            oldLast.next = tail;
        }
        N++;
    }
    public Item dequeue() {
        Node popped = head;
        head = head.next;
        N--;
        return popped.item;
    }
   /* public String toString() {

        if (isEmpty()) {
            return " ";
        }

        StringBuilder sb = new StringBuilder();
        Node current = head;

        while(current != null){
            sb.append(" ").append(current.item);
            current = current.next;
        }

        return sb.toString();

    }*/
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = head;
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
        public boolean hasNext() {
            return current != null;
        }
    }
}
  /*class Queue<Item> implements Iterable<Item> {
    private Node first; // link to least recently added node
    private Node last; // link to most recently added node
    private int N; // number of items on the queue

    private class Node { // nested class to define nodes
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    } // Or: N == 0.

    public int size() {
        return N;
    }

    public void enqueue(Item item) { // Add item to the end of the list.
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }

    public Item dequeue() { // Remove item from the beginning of the list.
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}*/
























