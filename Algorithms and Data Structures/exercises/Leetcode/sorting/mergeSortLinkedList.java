package com.example.packages.exercises.Leetcode.sorting;
import com.example.packages.exercises.Leetcode.sorting.LinkedList.*;
import com.example.packages.dataStructures.queue.QueueLinkedListImplementation;
import java.util.Collections;


public class mergeSortLinkedList {

    public static LinkedList mergeSort(Node head) {
        LinkedList result;
        Node oldX;
        QueueLinkedListImplementation<LinkedList> queue = new QueueLinkedListImplementation<>();
        for(Node x = head; x != null; x = oldX ) {
            oldX = x.next;
            x.next = null;
            LinkedList list = new LinkedList();
            list.append(x.data);
            queue.enqueue(list);
        }

        while(!queue.isEmpty()) {
            LinkedList first = queue.dequeue();
            LinkedList second = queue.dequeue();

            result = merge(first, second);
            queue.enqueue(result);


            if (queue.size() == 1) {
                break;
            }
        }

        return queue.dequeue();
    }

    public static LinkedList merge(LinkedList first, LinkedList second) {
        LinkedList temp = new LinkedList();
        Node headFirst = null;
        Node headSecond = null;

        if (first != null) {
            headFirst = first.head;
        }
        if (second != null) {
            headSecond = second.head;
        }

        while (headFirst != null && headSecond != null) {
            if(headFirst.data < headSecond.data) {
                temp.append(headFirst.data);
                headFirst = headFirst.next;
            }
            else {
                temp.append(headSecond.data);
                headSecond = headSecond.next;
            }
        }
        while(headFirst != null) {
            temp.append(headFirst.data);
            headFirst = headFirst.next;
        }
        while(headSecond != null) {
            temp.append(headSecond.data);
            headSecond = headSecond.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        Node first = new Node(9);
        Node second = new Node(0);
        Node third = new Node(3);
        Node fourth = new Node(11);
        Node fifth = new Node(2);
        Node sixth = new Node(1);
        Node seven = new Node(5);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seven;


        LinkedList myList = mergeSort(first);

        System.out.println(myList);
    }
}







