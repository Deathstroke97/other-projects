package com.example.packages.algorithms.sorting;

import java.util.ArrayList;
import java.util.*;

public class exercises {
    public static  void merge(int[] a, int[] b, int lastA, int lastB ) {
        int indexA = lastA - 1;
        int indexB = lastB - 1;
        int indexMerged = indexA + indexB + 1;

        while(indexA >= 0 && indexB >= 0) {
            if(a[indexA] > b[indexB]) {
                a[indexMerged] = a[indexA];
                indexMerged--;
                indexA--;
            }
            else{
                a[indexMerged] = b[indexB];
                indexB--;
                indexMerged--;
            }
        }
        while(indexB >= 0) {
            a[indexMerged] = a[indexB];
            indexB--;
            indexMerged--;
        }

    }

    public static void anagramsNextToEachOther(String[] arr) {
        ArrayList<String>[] list;
        int maxLength = arr[0].length();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i].length() > maxLength) {
                maxLength = arr[i].length();
            }
        }

        list = new ArrayList[maxLength + 1];
        for (int i = 0; i < maxLength + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < arr.length; i++) {
            list[arr[i].length()].add(arr[i]);
        }
        int outer = 0;
        for(int i = 0; i < list.length; i++) {
            for(int j = 0; j < list[i].size(); j++ ) {
                arr[outer++] = list[i].get(j);
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    public static String sortChars(String str) {
        char[] content = str.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public static class AnagramComparator implements Comparator<String> {
        public int compare(String s1, String s2) {
            return sortChars(s1).compareTo(sortChars(s2));
        }
    }

    public static void sort(String[] arr) {
        HashMap<String, LinkedList<String>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            String key = sortChars(arr[i]);
            if(!map.containsKey(key)) {
                map.put(key, new LinkedList<String>());
            }
            else{
                map.get(key).add(arr[i]);
            }
        }
        int index = 0;
        for (String key : map.keySet()) {
            LinkedList<String> list = map.get(key);
            for(String str : list) {
                arr[index++] = str;
            }
        }
    }

    public int search(int[] a, int left, int right, int x) {
        int mid = (left + right) / 2;
        if(left > right) {
            return -1;
        }
        if(a[mid] == x) {
            return mid;
        }
        if(a[left] < a[mid]) {
            if(x >= a[left] && x <= a[mid]) {
                return search(a, left, mid - 1, x);
            }
            else{
                return search(a, mid + 1, right, x);
            }
        }
        else if(a[left] > a[mid]) {
            if(x >= a[mid] && x <= a[right]) {
                return search(a, mid + 1, right, x);
            }
            else{
                return search(a, left, mid  - 1, x);
            }
        }
        else if(a[left] == a[mid]) {
            if(a[mid] != a[right]) {
                return search(a, mid + 1, right, x);
            }
            else{
                int result = search(a, left, mid - 1, x);
                if(result == -1) {
                    return search(a, mid + 1, right, x);
                }
                else{
                    return result;
                }
            }
        }
        return -1;
    }

    public static int findLocation(String[] string, String target, int low, int high) {
        int middle = (low + high) / 2;
        if(string[middle].equals(target)) {
            return middle;
        }
        else if(low > high) {
            return -1;
        }
        else if (!string[middle].equals("")) {
            if(string[middle].compareTo(target) > 0) {
                return findLocation(string, target, middle + 1, high);
            }
            else {
                return findLocation(string, target, low, middle - 1);
            }
        }
        else {
            int result = findLocation(string, target, low, middle - 1);
            if(result == -1) {
                return findLocation(string, target, middle + 1, high);
            }
            else {
                return result;
            }
        }

    }
    public static int searchR(String[] strings, String str, int first, int last) {
        if (first > last) return -1;
        int middle = (last + first) / 2;


        if(strings[middle].isEmpty()) {
            int left = middle - 1;
            int right = middle + 1;
            while(true) {
                if(left < first || right > last) {
                    return -1;
                }
                else if(left >= first && !strings[left].isEmpty()) {
                    middle = left;
                    break;
                }
                else if(right <= last && !strings[right].isEmpty()) {
                    middle = right;
                    break;
                }
                left--;
                right++;
            }
        }

        if(strings[middle].equals(str)) {
            return middle;
        }
        else if(strings[middle].compareTo(str) > 0) {
            return searchR(strings, str, first, middle - 1);
        }
        else {
            return searchR(strings, str, middle + 1, last);
        }
    }

    public static int search(String[] strings, String str) {
        if(str == null || str == "" || strings == null) {
            return -1;
        }
        return searchR(strings, str, 0, strings.length - 1);
    }


    public static int find(int[] array, int low, int high, int target) {
    if(low > high) {
        return - 1;
    }
    int middle = (low + high) / 2;

    if (array[middle] == target) {
        return middle;
    }
    else if(array[middle] > target) {
        return find(array, low, middle - 1, target);
    }
    else {
        return find(array, middle + 1, high,  target);
    }
}

    public static void findWhichRow(int[][] matrix, int low, int high,  int target) {
        int middle = (low + high) / 2;
        if (low > high) {
            low = low - 1;
            if(matrix[low][1] == target) {
                System.out.println("row: " + low + "column: " + 1);
            }
            else{
                while(low >= 0 && target < matrix[low][1]) {
                    low--;
                }
                if(low < 0) {
                    System.out.println("Not found");
                    return;
                }
                else{
                    int row = low;
                    int result = find(matrix[low], 0, matrix[low].length - 1, target);
                    if(result == -1) {
                        System.out.println("Not found");
                        return;
                    }
                    else{
                        System.out.println("row: " + row + " column: " + result);
                        return;
                    }
                }
            }
        }
        if (matrix[middle][0] == target) {
            System.out.println("row: " + middle + " column: " + 0);
            return;
        }
        else if(matrix[middle][0] > target) {
            findWhichRow(matrix, low, middle - 1, target);
        }
        else {
            findWhichRow(matrix, middle + 1 , high, target);
        }

    }

    static class Node {
        int data;
        Node right, left;
        int N;
        public Node(int data, int N) {
            this.data = data;
            this.N = N;
        }
    }

    static class BinarySearchTree {

        private Node root;

        public void put(int data) {
            root = put(root, data);
        }

        public Node put(Node x, int data) {
            if (x == null) {
                return new Node(data, 1);
            }
            else if (x.data < data) {
                x.right = put(x.right, data);
            }
            else if (x.data > data) {
                x.left = put(x.left, data);
            }
            else {
                x.data = data;
            }
            x.N = size(x.left) + size(x.right) + 1;
            return x;
        }

        public int get (int data) {
            return get(root, data);
        }
        public int get(Node x, int data) {
            if (x == null) {
                return -1;
            }
            if (x.data > data) {
                return get(x.left, data);
            }
            else if(x.data < data) {
                return get(x.right, data);
            }
            else {
                return x.data;
            }
        }

        public int size() {
            return size(root);
        }

        public int size(Node x) {
            if(x == null) {
                return 0;
            }
            return x.N;
        }

        public int getRankOfNumber(int data) {
            return getRankOfNumber(root, data);
        }

        public int getRankOfNumber(Node x, int data) {
            if (x == null) {
                return 0;
            }
            else if(x.data < data) {
                return size(x.left) + getRankOfNumber(x.right, data) + 1;
            }
            else if (x.data > data) {
                return getRankOfNumber(x.left, data);
            }
            else {
                return size(x.left);
            }
        }

    }






    public static void main(String[] args) {

        String[] input =  {"at", "", "", "", "ball", "", "", "car"};
        //System.out.println(findLocation(input, "ball", 0, 7 ));
        //System.out.println(input[1].isEmpty());
        //System.out.println(search(input, "car" ));
        /*int[][] matrix = {{15, 20, 40, 85}, {20, 35, 80, 95}, {30, 55, 95, 105}, {40, 80, 100, 120}};
        findWhichRow(matrix, 0, 3, 55);*/

        BinarySearchTree tree =  new BinarySearchTree();
        tree.put(5);
        tree.put(1);
        tree.put(4);
        tree.put(4);
        tree.put(5);
        tree.put(9);
        tree.put(7);
        tree.put(13);
        tree.put(3);
        //System.out.println(tree.get(5));
        System.out.println(tree.getRankOfNumber(4));




    }


}
