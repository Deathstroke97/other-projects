package com.example.packages.exampleCodes;
import java.util.*;
import java.util.ArrayList;

public class ThreeSumClosest {
    public static boolean less(int v, int w) {
        return v < w;
    }


    public static int[] insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int currentEl = a[i];
            int j = i - 1;
            while (j >= 0 && less(currentEl, a[j])) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = currentEl;
        }
        return a;

    }

    public static void ThreeSumClosest(int[] array, int target) {
        int[] sorted = insertionSort(array);
        ArrayList<Integer> members = new ArrayList<>();
        int sum;
        System.out.println(Arrays.toString(sorted));
        for (int i = 0; i < sorted.length -2; i++) {
            for(int j = i + 1; j < sorted.length - 1; j++) {
                for(int k = j + 1; k < sorted.length; k++) {

                    sum = sorted[i] + sorted[j] + sorted[k];
                    if(sum < target) {
                        members = new ArrayList<>();
                        members.add(sorted[i]);
                        members.add(sorted[j]);
                        members.add(sorted[k]);
                    }

                }
            }
        }
        System.out.println(members);

    }

    public static void main(String[] args) {
        int[] num = {-1, 2, 1, -4};
        ThreeSumClosest(num, 1);
    }

}
