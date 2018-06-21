package com.example.packages.exercises.Leetcode.sorting;
import java.util.*;

public class MaximumGap {

    public static int maximumGap(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 <= nums.length - 1) {
                if (nums[i + 1] - nums[i] > max) {
                    max = nums[i + 1] - nums[i];
                }
            }
        }
        return max;

    }

    public static void main(String[] args) {
        int[] arr = {3,6,9,1};
        System.out.println(maximumGap(arr));
    }
}
