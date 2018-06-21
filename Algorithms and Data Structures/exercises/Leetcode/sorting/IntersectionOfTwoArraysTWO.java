package com.example.packages.exercises.Leetcode.sorting;
import java.util.*;

public class IntersectionOfTwoArraysTWO {
    public static void main(String[] args) {

        int[] nums1 = {1, 3};
        int[] nums2 = {1, 2 ,3};

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList list = new ArrayList();

        if (nums1.length == 0 || nums2.length == 0) {
            int[] nums3 = {};
            System.out.println(Arrays.toString(nums3));
            return;
        }

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));

        int length = nums1.length > nums2.length ? nums1.length : nums2.length;

        int i = 0, j = 0;

        while(j < length && i < length) {

            if (i > nums1.length - 1 || j >  nums2.length - 1) {
                break;
            }

            if (nums1[i] > nums2[j]) {
                j++;
            }
            else if(nums1[i] < nums2[j] ) {
                i++;
            }
            else  {
                list.add(nums2[j]);
                i++;
                j++;
            }
        }

        int[] result = new int[list.size()];
        Object[] arr = list.toArray();
        for (int w = 0; w < list.size(); w++) {
            result[w] = (int)list.get(w);
        }
        System.out.println(Arrays.toString(result));

    }

}
