package com.example.packages.exercises.binaryTree;
import com.example.packages.dataStructures.BinarySearchTree.BinarySearchTreeST;

import java.util.*;
//import com.example.packages.dataStructures.BinarySearchTree.BinarySearchTreeST;

class BinarySearchTree1 {
    private Node root;

    private class Node {
        String data;
        Node left, right, parent;

        Node(String data) {
            this.data = data;
        }

        public String toString() {
            return data;
        }
    }

    public void put(String newData) {
        root = put(root, newData, null);
    }

    public Node put(Node x, String newData, Node parent) {

        if (x == null) {
            Node newNode = new Node(newData);
            newNode.parent = parent;
            return newNode;
        }
        int compare = newData.compareTo(x.data);
        if (compare < 0)
            x.left = put(x.left, newData, x);
        else if (compare > 0) {
            x.right = put(x.right, newData, x);
        } else x.data = newData;
        return x;
    }

    public Node get(String Data) {
        return get(root, Data);
    }

    public Node get(Node x, String Data) {
        if (x == null)
            return null;
        int compare = Data.compareTo(x.data);
        if (compare > 0)
            return get(x.right, Data);
        if (compare < 0)
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



    public boolean check(Node big, Node young) {

        boolean right = false;
        boolean left = false;

        if(big == null || young == null) {
            return false;
        }

        if(young.data.equals(big.data) && young.right == null) {
            return true;
        }
        else if(!young.data.equals(big.data) && young.right == null){
            return false;
        }

        else if (young.data.equals(get(young.data).data)) {
            Node rootOfYoungInBig = get(big, young.data);
            left = check(rootOfYoungInBig.left, young.left);
            right = check(rootOfYoungInBig.right, young.right);
        }

        if (right == true && left == true)
            return true;
        return false;
    }


    public boolean isSubtree(BinarySearchTree1 bst) {
        return check(root, bst.root);
    }
}




 class isSubtree {

    public static void main(String[] args) {
        BinarySearchTree1 bst1 = new BinarySearchTree1();
        BinarySearchTree1 bst2 = new BinarySearchTree1();

        bst1.put("S");
        bst1.put("D");
        bst1.put("H");
        bst1.put("T");
        bst1.put("W");
        bst1.put("B");
        bst1.put("A" );
        bst1.put("C" );
        bst1.put("I" );



        bst2.put("B" );
        bst2.put("A");
        bst2.put("C" );

        System.out.println(bst1.isSubtree(bst2));


        //bst1.inOrder();

    }
}


