package com.example.packages.algorithms.sorting;

import java.util.*;

public class bucketSort{

    public static void sort(int[] a, int maxVal) {
        int [] bucket=new int[maxVal+1];

        for (int i=0; i<bucket.length; i++) {
            bucket[i]=0;
        }

        for (int i=0; i<a.length; i++) {
            bucket[a[i]]++;
        }

        int outPos=0;
        for (int i=0; i<bucket.length; i++) {
            for (int j=0; j<bucket[i]; j++) {
                a[outPos++]=i;
            }
        }
        System.out.println(Arrays.toString(a));
    }


    public static void main(String[] args) {
        int maxVal=5;
        int [] data= {4,2,0,1};

        System.out.println("Before: " + Arrays.toString(data));
        sort(data,4);
        System.out.println("After:  " + Arrays.toString(data));
    }
}
