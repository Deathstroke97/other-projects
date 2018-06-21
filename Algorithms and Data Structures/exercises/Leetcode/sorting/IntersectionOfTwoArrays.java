package com.example.packages.exercises.Leetcode.sorting;
import java.util.*;
import com.example.packages.dataStructures.HashTables.SeparateChainingHashST;
import java.util.LinkedList;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {

        SeparateChainingHashST<Integer, Integer> map1 = new SeparateChainingHashST<>();
        SeparateChainingHashST<Integer, Integer> map2 = new SeparateChainingHashST<>();
        SeparateChainingHashST<Integer, Integer> map3 = new SeparateChainingHashST<>();
        HashMap<Integer, Integer> map = new HashMap<>();




        ArrayList<Integer> list = new ArrayList<>();
        int[] array1 = {1, 2, 2, 1};
        int[] array2 = {2, 2, 1};

        for(Integer i : array1) {
            map1.put(i, i);
        }
        for (Integer j : array2) {
            map2.put(j, j);
        }

        for (Integer i : array1) {
            if(map2.contains(i) && !map3.contains(i)) {
                list.add(i);
                map3.put(i, i);
            }
        }

        for (Integer j : array2) {
            if(map1.contains(j)&& !map3.contains(j)) {
                list.add(j);
                map3.put(j, j);
            }
        }


        int[] result = new int[list.size()];
        Object[] myArray = list.toArray();
        for (int i = 0; i < myArray.length; i++) {
            result[i] = (int)myArray[i];
        }



        /*Integer[] result = new Integer[list.size()];
        result = list.toArray(result);
        for (int i = 0; i < list.size(); i++) {
            result[i] = (int)list.get(i);
        }*/
        /*for (Integer myInt : result) {
            System.out.println(myInt);
        }*/
    }
}
