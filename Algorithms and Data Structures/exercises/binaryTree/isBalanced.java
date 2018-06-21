package com.example.packages.exercises.binaryTree;


import com.example.packages.dataStructures.SymbolTable.BinarySearchST;
import com.example.packages.dataStructures.queue.QueueLinkedListImplementation;
import com.example.packages.stdlib.In;

import java.util.*;


class BinarySearchTreeST<Key extends Comparable<Key>, Value> {

    Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;


        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null)
            return 0;
        return x.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node x, Key key) {
        if (x == null)
            return null;
        int compare = key.compareTo(x.key);
        if (compare < 0)
            return get(x.left, key);
        else if (compare > 0)
            return get(x.right, key);
        else
            return x.val;

    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    public Node put(Node x, Key key, Value val) {
        if (x == null)
            return new Node(key, val, 1);
        int compare = key.compareTo(x.key);
        if (compare < 0)
            x.left = put(x.left, key, val);
        else if (compare > 0) {
            x.right = put(x.right, key, val);
        } else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Node floor(Node x, Key key) {
        if (x == null)
            return null;
        int compare = key.compareTo(x.key);
        if (compare < 0)
            return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null)
            return t;
        else
            return x;
    }

    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null)
            return null;
        else
            return x.key;
    }

    public Node ceiling(Node x, Key key) {
        if (x == null)
            return null;
        int compare = key.compareTo(x.key);
        if (compare > 0)
            return ceiling(x.right, key);
        Node t = ceiling(x.left, key);
        if (t != null)
            return t;
        else
            return x;
    }

    public Key min() {
        return min(root).key;
    }

    public Node min(Node x) {
        if (x.left == null)
            return x;
        else
            return min(x.left);
    }

    public Key max() {
        return max(root).key;
    }

    public Node max(Node x) {
        if (x.right == null)
            return x;
        else
            return max(x.right);
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    public Node select(Node x, int k) {
        if (x == null)
            return null;
        int t = size(x.left);
        if (t < k)
            return select(x.right, k - t - 1);
        if (t > k)
            return select(x.left, k);
        else
            return x;
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    public int rank(Node x, Key key) {
        if (x == null)
            return 0;
        int compare = key.compareTo(x.key);
        if (compare > 0)
            return 1 + size(x.left) + rank(x.right, key);
        if (compare < 0)
            return rank(x.left, key);
        else
            return size(x.left);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    public Node deleteMin(Node x) {
        if (x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    public Node delete(Node x, Key key) {
        if (x == null)
            return null;

        int compare = key.compareTo(x.key);
        if (compare < 0)
            x.left = delete(x.left, key);
        if (compare > 0)
            x.right = delete(x.right, key);
        else {
            if (x.right == null)
                return x.left;
            if (x.left == null)
                return x.right;
        }
        Node t = x;
        x.right = deleteMin(t.right);
        x.left = t.left;
        return x;
    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(Node x) {
        if (x != null) {
            inOrder(x.left);
            System.out.println(x.key + " " + x.val);
            inOrder(x.right);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(Node x) {
        if (x != null) {
            System.out.println(x.key + " " + x.val);
            preOrder(x.left);
            preOrder(x.right);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    public void postOrder(Node x) {
        if (x != null) {
            postOrder(x.left);
            postOrder(x.right);
            System.out.println(x.key + " " + x.val);
        }
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key low, Key high) {
        QueueLinkedListImplementation queue = new QueueLinkedListImplementation();
        keys(root, queue, low, high);
        return queue;
    }

    public void keys(Node x, QueueLinkedListImplementation queue, Key low, Key high) {
        if (x == null)
            return;
        int compareLow = low.compareTo(x.key);  //F - S < 0, means S appears after F
        int compareHigh = high.compareTo(x.key); // T - S > 0, means S appears before T, we can now conclude that S is in a range

        if (compareLow < 0)
            keys(x.left, queue, low, high);
        if (compareLow <= 0 && compareHigh >= 0)
            queue.enqueue(x.key);
        if (compareHigh > 0)
            keys(x.right, queue, low, high);
    }


    public int MaxDepth(Node x) {
        if (x == null) {
            return 0;
        }
        return 1 + Math.max(MaxDepth(x.left), MaxDepth(x.right));
    }

    public int MinDepth(Node x) {
        if (x == null) {
            return 0;
        }
        return 1 + Math.min(MinDepth(x.left), MinDepth(x.right));
    }

    public boolean isBalanced() {
        int k = MaxDepth(root) - MinDepth(root);
        if (k <= 1)
            return true;
        return false;

    }

    public int height() {
        int height = height(root);
        return height;
    }

    public int height(Node x) {
        if (x == null) {
            return -1;
        }
        return 1 + Math.max(height(x.left), height(x.right));
    }

    public void connectLevels() {
        ArrayList<LinkedList<Node>> result = collectWithCommonHeight(root);

        for (LinkedList<Node> list : result){
            for(Node node : list) {
                System.out.println(node.key);
            }
            System.out.println("\n");
        }
        System.out.println(result);
    }





    ArrayList<LinkedList<Node>> collectWithCommonHeight(Node x) {
        ArrayList<LinkedList<Node>> result = new ArrayList<>();
        LinkedList<Node> list = new LinkedList<>();
        list.add(x);
        int level = 0;
        result.add(level, list);


        while(true) {
            list = new LinkedList<Node>();
            for(int i = 0; i < result.get(level).size(); i++) {
                Node n = (Node)result.get(level).get(i);
                if(n.left != null){
                    list.add(n.left);
                }
                if(n.right != null) {
                    list.add(n.right);
                }
            }
            if(list.size() == 0){
                break;
            }
            level++;
            result.add(level, list);


        }

        return result;

    }

    public static void main(String[] args) {
        BinarySearchTreeST<String, Integer> bst = new BinarySearchTreeST<>();
        bst.put("S", 0);
        bst.put("A", 4);
        bst.put("D", 6);
        bst.put("H", 7);
        bst.put("T", 6);
        bst.put("W", 87);
        bst.put("B", 89);
        bst.connectLevels();

    }
}

























