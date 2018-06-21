
package com.example.packages.dataStructures.linkedList;

import java.util.Iterator;

public class buildLinkedList {

    static public class Node<T> {
        public Node next;
        public T data;
        public Node previous;
        public Node(T data) {
            this.data = data;
        }

    }

    static public class LinkedList<T> implements Iterable<T>   {
        public Node head;

        public void append(T data) {
            if (head == null) {
                head = new Node(data);
                head.previous = null;
                return;
            }

            Node current = head;
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
        public void previous(T data) {

            for(Node x = head; x != null; x = x.next) {
                if(x.data == data){
                    System.out.println((T)x.previous.data);
                    return;
                }
            }
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


        public Iterator<T> iterator() {
            return new LinkedListIterator();
        }
        private  class LinkedListIterator implements Iterator<T>{
            Node current = head;
            public boolean hasNext() {
                return current != null;
            }
            public T next() {
                Node temp = current;
                current = current.next;
                return (T)temp.data;
            }
        }



    }

        public static void main(String[] args) {
            LinkedList<Integer> list = new LinkedList<>();
            list.append(4);
            list.append(1);
            list.append(2);
            list.append(0);


            Iterator<Integer> iterator = list.iterator();
            while(iterator.hasNext()) {
                System.out.print(iterator.next()+ " ");
            }


        }
}


