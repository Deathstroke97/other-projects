package com.example.packages.algorithms.sorting;
import java.util.*;

// Java implementation of Counting Sort
/*
public class countingSort
{
    void sort(char arr[])
    {
        int n = arr.length;

        // The output character array that will have sorted arr
        char output[] = new char[n];

        // Create a count array to store count of inidividul
        // characters and initialize count array as 0
        int count[] = new int[256];
        for (int i=0; i<256; ++i)
            count[i] = 0;

        // store count of each character
        for (int i=0; i<n; ++i)
            ++count[arr[i]];

        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i=1; i<=255; ++i)
            count[i] += count[i-1];

        // Build the output character array
        for (int i = 0; i<n; ++i)
        {
            output[count[arr[i]]-1] = arr[i];
            --count[arr[i]];
        }

        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i<n; ++i)
            arr[i] = output[i];
    }

    // Driver method
    public static void main(String args[])
    {
        countingSort ob = new countingSort();
        char arr[] = {'g', 'e', 'e', 'k', 's', 'f', 'o',
                'r', 'g', 'e', 'e', 'k', 's'
        };

        ob.sort(arr);

        System.out.print("Sorted character array is ");
        for (int i=0; i<arr.length; ++i)
            System.out.print(arr[i]);
    }
}
*/
public class countingSort
{
    void sort(int arr[])
    {
        int n = arr.length;

        // The output character array that will have sorted arr
        int output[] = new int[n];

        // Create a count array to store count of inidividul
        // characters and initialize count array as 0
        int count[] = new int[10];
        for (int i=0; i < 10; i++)
            count[i] = 0;

        // store count of each character
        for (int i=0; i<n; i++)
            count[arr[i]]++;

        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i=1; i<10; ++i)
            count[i] += count[i-1];

        // Build the output character array
        for (int i = 0; i<n; i++)
        {
            output[count[arr[i]]-1] = arr[i];
            count[arr[i]]--;
        }

        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i<n; ++i)
            arr[i] = output[i];
    }

    // Driver method
    public static void main(String args[])
    {
        countingSort ob = new countingSort();
        int arr[] = {9, 8, 3, 1, 0};

        ob.sort(arr);

        System.out.print("Sorted character array is ");
        for (int i=0; i<arr.length; ++i)
            System.out.print(arr[i] + " ");
    }
}

