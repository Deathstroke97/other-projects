package com.example.packages.exercises.Leetcode.sorting;
import java.util.*;

class Solution {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Integer> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++) {

            final Integer floor = values.floor(nums[ind] + t);
            final Integer ceil = values.ceiling(nums[ind] - t);
            if ((floor != null && floor >= nums[ind])
                    || (ceil != null && ceil <= nums[ind])) {
                return true;
            }

            values.add(nums[ind]);
            if (ind >= k) {
                values.remove(nums[ind - k]);
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 9};
        int k = 2;
        int t = 2;
        System.out.println(containsNearbyAlmostDuplicate(arr, k, t));

    }

}

