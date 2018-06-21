package com.example.packages.algorithms.sorting;
import java.util.*;
import com.example.packages.stdlib.*;



public class Shell
{
    public static void sort(Comparable[] a)
    { // Sort a[] into increasing order.
        int N = a.length;
        int h = 1;
        while (h < N/3) {
            h = 3*h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        }
        System.out.println(h);
        while (h >= 1)
        { // h-sort the array.
            for (int i = h; i < N; i++)
            { // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                for (int j = i; j >= h && Sorting.less(a[j], a[j-h]); j -= h)
                    Sorting.swap(a, j, j-h);
            }
            h = h/3;
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        //Integer[] array = {5, 7, 9, 0, 4, 2, 11, 9, -1, 1 };
        //sort(array);
        int h = 4;
        System.out.println(h/3);
    }

}
