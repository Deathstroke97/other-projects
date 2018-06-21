package com.example.packages.dataStructures.linkedList;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Iterator;





public class LinkedList<T> implements Iterable<T> {
    public static class Node<T> {
        public Node next;
        public T data;
        Node previous;
        public Node(T data) {
            this.data = data;
        }
    }
    public static Node head;
    static Node sorted;


    public void append(T data) {
        if (head == null) {
            head = new Node(data);
            head.previous = null;
            return;
        }
        Node current =  head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node(data);
        current.next.previous = current;

    }

    public void prepend(T data) {
        Node newHead = new Node(data);
        newHead.next = head;
        newHead.previous = null;
        head = newHead;

    }

    public void deleteWithValue(T data) {
        if (head == null) return;
        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
            current.next.previous = current;
        }

    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public int headValue() {
        return (int) head.data;
    }

    public Node head() {
        return head;
    }

    public static void sortedInsert(Node newNode) {
        if (sorted == null || (int) newNode.data < (int) sorted.data) {
            newNode.next = sorted;
            sorted = newNode;
        } else {
            Node current = sorted;
            while (current.next != null && (int) current.next.data < (int) newNode.data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public int size() {
        int N = 0;
        Node current = head;
        while(current != null) {
            N++;
            current = current.next;
        }
        return N;
    }


/*    public static LinkedList<Integer> insertionSortL(Node headref) {
        Node current = headref;
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> result = new LinkedList<>();
        sorted = null;
        while (current != null) {
            Node next = current.next;
            sortedInsert(current);
            current = next;
        }
        System.out.println("sortedHead: " + sorted.data);
        head = sorted;
        while (head != null) {
            int item = (int) head.data;
            arrayList.add(item);
            head = head.next;
        }
        result = toLinkedList(arrayList);
        return result;
    }*/

    public static LinkedList<Integer> toLinkedList(ArrayList<Integer> list) {

        LinkedList<Integer> result = new LinkedList<>();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {

            result.append(iterator.next());
        }
        return result;
    }


    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        Node current = head;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            Node temp = current;
            current = current.next;
            return (T) temp.data;
        }
    }




/*
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(8);
        list.append(11);
        list.append(0);
        list.append(3);

        LinkedList<Integer> result = list.insertionSortL(list.head());
        Iterator<Integer> iterator = result.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("Size:" + result.size());

    }*/
}



