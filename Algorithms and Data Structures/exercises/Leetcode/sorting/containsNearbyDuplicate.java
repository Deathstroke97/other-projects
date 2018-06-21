package com.example.packages.exercises.Leetcode.sorting;
import java.util.*;
import com.example.packages.dataStructures.HashTables.SeparateChainingHashST;

public class containsNearbyDuplicate {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums) && i - map.get(nums[i]) == k) {
                    return true;
            }
            else{
                map.put(nums[i], i);
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1};
        System.out.println(containsNearbyDuplicate(arr, 1));
    }
}
