package com.example.packages.exercises.linkedList;
import com.example.packages.dataStructures.stack.StackLinkedListImplementation;
import com.example.packages.stdlib.In;

import java.util.*;


class Node<T> {
        Node next;
        T data;

        public Node(T data) {
            this.data = data;
        }

    }

    class LinkedList<T> implements Iterable<T> {

        static Node head;

        public void append(T data) {
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

        public void prepend(T data) {
            Node newHead = new Node(data);
            newHead.next = head;
            head = newHead;
        }

        public void deleteWithValue(T data) {
            if (head == null) return;

            if (head.data == data) {
                head = head.next;
                return;
            }
            Node current = head;
            while (current.next != null) {
                if (current.next.data == data) {
                    current.next = current.next.next;
                    return;
                }
            }
        }

        public Iterator<T> iterator() {
            return new LinkedListIterator();
        }

        private class LinkedListIterator implements Iterator<T> {
            Node current = head;

            public T next() {
                if (hasNext()) {
                    T data = (T) current.data;
                    current = current.next;
                    return data;
                }
                return null;
            }

            public boolean hasNext() {
                return current != null;
            }

        }

        public void removeDuplicates() {
            for (Node x = head; x != null; x = x.next) {
                for (Node y = head.next; y != null; y = y.next) {
                    if (x.data == y.data) {
                        x.next = y.next;
                    }
                }
            }
        }

        public void deleteDups(Node n) {
            HashMap table = new HashMap();
            Node previous = null;
            while (n != null) {
                if (table.containsKey(n.data)) {
                    previous.next = n.next;
                } else {
                    table.put(n.data, true);
                    previous = n;
                }
                n = n.next;
            }
        }

        public void deleteDups2(Node n) {
            if (n == null) return;
            Node previous = n;
            Node current = previous.next;

            while (current != null) {
                Node runner = n;

                while (runner != current) {
                    if (runner.data == current.data) {
                        Node temp = current.next;
                        previous.next = temp;
                        current = temp;
                        break;
                    }
                    runner = runner.next;
                }
                if (current == runner) {
                    previous = current;
                    current = current.next;
                }
            }
        }

        public void nthlast(Node x, int k) {
            int nthToLast = 0;
            int length = 0;
            int u = 0;
            Node needed = x;
            for (Node current = x; current != null; current = current.next) {
                length++;
            }
            System.out.println("Length: " + length);
            nthToLast = length - k;

            while (u < nthToLast) {
                needed = needed.next;
                u++;
            }
            System.out.println(needed.data);
        }

        public void nthLastRecursion(Node x, int initial, int k, int length) {
            if (length == k + initial - 1)
                System.out.println(x.data);
            else
                nthLastRecursion(x.next, initial - 1, k, length);
        }

        public void nthToLast(Node x, int k) {
            if (x == null)
                return;
            Node p1 = x;
            Node p2 = x;
            for (int i = 0; i < k; i++) {
                if (p2 == null)
                    return;
                p2 = p2.next;
            }
            while (p2 != null) {
                p2 = p2.next;
                p1 = p1.next;
            }
            System.out.println(p1.data);
        }

        public void middleNode(Node x) {
            Node middle = x;
            int i = 0;
            for (Node current = x; x != null; x = x.next) {
                if (i % 2 != 0)
                    middle = middle.next;
                i++;
            }
            System.out.println(middle.data);
        }

        public void findBeginning(Node x) {
            Node slow = x;
            Node faster = x;
            while (slow != null || faster.next != null || faster.next.next != null) {
                slow = slow.next;
                faster = faster.next.next;
                if (slow == faster) {
                    System.out.println("Slow's data: " + slow.data);
                    System.out.println("Faster's data: " + faster.data);
                    break;
                }
            }
            if (faster == null) {
                System.out.println("no loop");
                return;
            }
            slow = x;
            while (slow != faster) {
                slow = slow.next;
                faster = faster.next;
            }
            System.out.println(slow.data);
        }

        public static void Sum(Node<Integer> x, Node<Integer> y) {
            LinkedList<Integer> result = new LinkedList<>();
            StackLinkedListImplementation<Integer> stack = new StackLinkedListImplementation<>();
            ArrayList<Integer> list = new ArrayList<>();

            while (x != null && y != null) {
                int sum = x.data + y.data;
                if (!stack.isEmpty())
                    sum += stack.pop();
                if (sum >= 10) {
                    String[] splitted = Integer.toString(sum).split("");
                    stack.push(Integer.parseInt(splitted[0]));
                    list.add(Integer.parseInt(splitted[splitted.length - 1]));
                } else {
                    list.add(sum);
                    System.out.println("Sum: " + sum);
                }
                x = x.next;
                y = y.next;
            }
            if (x != null) {
                list.add(x.data);
            }
            if (y != null) {
                list.add(y.data);
            }

            Node last = null;
            for (int i = list.size() - 1; i >= 0; i--) {
                Node oldLast = last;
                last = new Node(list.get(i));
                last.next = oldLast;
            }
            while (last != null) {
                System.out.println(last.data);
                last = last.next;
            }
        }

        static Node<Integer> addLists(Node<Integer> l1, Node<Integer> l2, int carry) {
            if (l1 == null && l2 == null)
                return null;
            Node result = new Node(carry);
            int value = carry;
            if (l1 != null) {
                value += l1.data;
            }
            if (l2 != null) {
                value += l2.data;
            }
            result.data = value % 10;
            Node more = addLists(l1 == null ? null : l1.next,
                    l2 == null ? null : l2.next,
                    value > 10 ? 1 : value % 10);
            result.next = more;
            return result;
        }

        Node reverse(Node node) {
            Node prev = null;
            Node current = node;
            Node next = null;
            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            node = prev;
            return node;
        }

        Node reverse2(Node x, Node p) {
            if(x == null)
                return null;
            if(x.next == null){
                x.next = p;
                return x;
            }

            Node r = reverse2(x.next, x);
            x.next = p;
            return r;
        }
    }





class removeDupliscates {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

       /* list.head =  new Node(10);
        Node first = new Node(9);*/
        Node second = new Node(1);
        Node third = new Node(5);
        Node fourth = new Node(6);
        Node fifth = new Node(0);
        Node sixth = new Node(2);


       /* list.head.next = first;
        first.next = second;*/
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = null;



        System.out.println(list.reverse(second).data);









        //list.findBeginning(second);



/*
        Node myFirst = new Node(5);
        Node mySecond = new Node(9);
        Node myThird = new Node(2);

        myFirst.next = mySecond;
        mySecond.next = myThird;
        myThird.next = null;

        //Sum(first, myFirst);


        Node result = addLists(first, myFirst, 0);
        while(result != null){
            System.out.println(result.data);
            result = result.next;
        }
        }*/

    }
}

