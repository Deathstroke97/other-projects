package com.example.packages.exercises.Leetcode.sorting;

import sun.awt.image.ImageWatched;

public class LinkedList {

    static public class Node {
         Node next;
         int data;
         public Node(int data) {
            this.data = data;
        }
        public String toString() {
             return Integer.toString(data);
        }
    }
    public Node head;

    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void prepend(int data) {
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }



    @Override
    public String toString() {
        String result = "";
        Node current = head;

        while (current != null) {
            result += current.data + ", ";
            current = current.next;
        }
        return result;
    }
}
