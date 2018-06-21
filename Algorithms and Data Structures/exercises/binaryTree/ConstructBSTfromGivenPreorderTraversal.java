package com.example.packages.exercises.binaryTree;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Index {
    int index = 0;
}

class BinaryTree {

    Index index = new Index();

    Node constructTreeUtil(int pre[], Index preIndex, int low, int high, int size) {

        if (preIndex.index >= size || low > high) {
            return null;
        }

        Node root = new Node(pre[preIndex.index]);
        preIndex.index = preIndex.index + 1;


        if (low == high) {
            return root;
        }

        int i;
        for (i = low; i <= high; ++i) {
            if (pre[i] > root.data) {
                break;
            }
        }

        root.left = constructTreeUtil(pre, preIndex, preIndex.index, i - 1, size);
        root.right = constructTreeUtil(pre, preIndex, i, high, size);

        return root;
    }

    Node constructTree(int pre[], int size) {
        return constructTreeUtil(pre, index, 0, size - 1, size);
    }

    void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        Node root = tree.constructTree(pre, size);
        System.out.println("Inorder traversal of the constructed tree is ");
        tree.printInorder(root);
    }
}





























/*
class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}


class BinaryTree {


    private Node root;

    public Node constructTreeUtil(int[] pre, int low, int high, int size){
        if(low > high || low >= size) {
            return null;
        }

        int currentMaxIndex = 0;
        root = new Node(pre[low]);
        low++;
        if (low == high) {
            return root;
        }

        for (int i = low; i < high; i++) {
            if (pre[i] > root.data) {
                currentMaxIndex = i;
                break;
            }
        }
        root.left = constructTreeUtil(pre, low,currentMaxIndex - 1, size);
        root.right = constructTreeUtil(pre, currentMaxIndex, high, size);

        return root;
    }

    public Node constructTree(int[] pre, int length) {
        return constructTreeUtil(pre, 0,length - 1, length);
    }
    void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

}

class test {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] pre = new int[]{10, 5, 1, 7, 40, 50};
        int length = pre.length;
        Node root = tree.constructTree(pre, length);
        System.out.println("Inorder traversal of tree :");
        tree.printInorder(root);
    }
}
*/

