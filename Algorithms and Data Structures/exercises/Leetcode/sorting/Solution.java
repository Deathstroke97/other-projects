/*
package com.example.packages.exercises.Leetcode.sorting;
import java.util.*;


public class Solution {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public static ArrayList mergeSort(ListNode head) {
        ArrayList result;
        ListNode oldX;
        ArrayDeque<LinkedList> queue = new ArrayDeque<>();

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
}
*/
