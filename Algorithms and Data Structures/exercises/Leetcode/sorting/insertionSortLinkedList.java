package com.example.packages.exercises.Leetcode.sorting;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class insertionSortLinkedList {


    public static ListNode insertionSortL(ListNode headref) {
        ListNode sorted = null;
        ListNode current = headref;
        while (current != null) {
            ListNode next = current.next;
            sorted = sortedInsert(current, sorted);
            current = next;
        }
        return sorted;
    }

    public static ListNode sortedInsert(ListNode newNode, ListNode sorted) {
        if (sorted == null || newNode.val < sorted.val) {
            newNode.next = sorted;
            sorted = newNode;
            return sorted;
        } else {
            ListNode current = sorted;
            while (current.next != null &&  current.next.val <  newNode.val) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            return sorted;

        }
    }


    public static void main(String[] args) {
        ListNode first = new ListNode(-1);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(0);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;

        ListNode result = insertionSortL(first);
        while(result != null) {
            System.out.print(result.val + ", ");
            result = result.next;
        }


    }

}
