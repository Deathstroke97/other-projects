package com.example.packages.exercises.binaryTree;
import java.util.*;
class BinarySearchTree {
    private Node root;

    private class Node {
        int data;
        Node left, right, parent;

        public Node(int data) {
            this.data = data;
        }
        public String toString() {
            return Integer.toString(data);
        }
    }

    public void put(int newInt) {
        root = put(root, newInt, null);
    }

    public Node put(Node x, int newInt, Node parent) {
        if (x == null) {
            Node newNode = new Node(newInt);
            newNode.parent = parent;
            return newNode;
        }

        if (newInt < x.data)
            x.left = put(x.left, newInt, x);
        else if (newInt > x.data) {
            x.right = put(x.right, newInt, x);
        } else x.data = newInt;
        return x;
    }

    public Node get(int Data) {
        return get(root, Data);
    }

    public Node get(Node x, int Data) {
        if (x == null)
            return null;

        if (Data > x.data)
            return get(x.right, Data);
        if (Data < x.data)
            return get(x.left, Data);
        else {
            return x;
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(Node x) {
        if (x != null) {
            inOrder(x.left);
            System.out.println("Data: "+ x.data + " " + "Parent: " + x.parent );
            inOrder(x.right);
        }
    }
/*

    void printList(ArrayList<Integer> list, int i) {
        for (int j = 0; j < i; j++) {
            System.out.println(list.get(i) + " ");
        }

    }


    void printKPathUtil(Node x, ArrayList<Integer> list, int k) {
        if(x == null) {
            return;
        }
        list.add(x.data);
        printKPathUtil(x.left, list, k);
        printKPathUtil(x.right, list, k);

        int sum = 0;

        for (int i = list.size() - 1; i >= 0; i--) {
            sum += list.get(i) ;
            if (sum == k) {
                printList(list, i);
            }
        }
        list.remove(list.size()-1);
    }
*/
    void printPath(ArrayList<Integer> list, int i, int level) {
        for(int j = i; j <= level; j++) {
            System.out.println(list.get(j)+ " ");
        }
        System.out.println();
    }


    void findSumUtil(Node x, int sum, ArrayList<Integer> list, int level) {
        if (x == null){
            return;
        }
        list.add(x.data);
        int temp = sum;
        for(int i = level; i > -1; i--){
            temp -= list.get(i);
            if(temp == 0){
                printPath(list, i ,level);
            }
        }
        ArrayList<Integer> c1 = (ArrayList<Integer>) list.clone();
        ArrayList<Integer> c2 = (ArrayList<Integer>) list.clone();
        findSumUtil(x.left, sum, list, level + 1);
        findSumUtil(x.right, sum, list, level + 1);
    }

    void findSum(int k) {
        ArrayList<Integer> list = new ArrayList<>();
        findSumUtil(root, k ,list, 0);
    }




    public static void main(String[] args) {
        BinarySearchTree bst1 = new BinarySearchTree();
        bst1.put(8);
        bst1.put(5);
        bst1.put(10);
        bst1.put(3);
        bst1.put(7);
        bst1.put(2);
        bst1.put(4);
        bst1.put(6);
        bst1.put(9);
        bst1.put(10);
        bst1.put(11);
        //bst1.inOrder();
        bst1.findSum(10);
        //bst1.findSum1(8);


    }
}

