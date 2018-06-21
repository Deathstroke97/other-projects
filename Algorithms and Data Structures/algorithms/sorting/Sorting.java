package com.example.packages.algorithms.sorting;
import java.util.*;
import com.example.packages.stdlib.*;
import com.example.packages.dataStructures.linkedList.LinkedList;
//import com.example.packages.dataStructures.linkedList.Node;
import sun.awt.image.ImageWatched;


public class Sorting {
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void swap(Comparable a[], int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void selectionSort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = min + 1; j < a.length; j++) {
                if (less(a[j], a[min]))
                    min = j;
            }
            swap(a, i, min);
        }
        System.out.println(Arrays.toString(a));
    }

    public static void insertionSort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            Comparable currentEl = a[i];
            int j = i - 1;
            while (j >= 0 && less(a[i], a[j])) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = currentEl;
        }
        System.out.println(Arrays.toString(a));
    }


    public static void shell(Comparable[] a) {
        int n = a.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < n; i++) {
                Comparable temp = a[i];
                int j = i;

                while (j >= gap && less(a[j], a[j - gap])) {
                    swap(a, j, j - gap);
                    j = j - gap;
                }

            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(Comparable[] a) {
        StdRandom.shuffle(a);
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(Comparable[] a, int low, int high) {
        if (low >= high) return;
        int j = partition(a, low, high);
        quickSort(a, low, j - 1);
        quickSort(a, j + 1, high);

    }

    public static int partition(Comparable[] a, int low, int high) {
        int i = low, j = high + 1;
        Comparable v = a[low];
        while (true) {
            while (less(a[++i], v)) {
                if (i == high) break;
            }
            while (less(v, a[--j])) {
                if (j == low) break;
            }
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, low, j);
        return j;
    }

    public static void heap(Comparable[] a) {
    }

    public static void mergeSort(Comparable[] a) {
        mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(Comparable[] a, int low, int high) {
        Comparable[] aux = new Comparable[high + 1];
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(a, low, middle);
            mergeSort(a, middle + 1, high);
            merge(a, aux, low, middle, high);
        }
    }

    public static void merge(Comparable[] a, Comparable[] aux, int low, int middle, int high) {
        int i = low, j = middle + 1;

        for (int k = low; k <= high; k++)
            aux[k] = a[k];
        for (int k = low; k <= high; k++) {
            if (i > middle) a[k] = aux[j++];
            else if (j > high) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    public static void mergeBU(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        int N = a.length;
        for (int size = 1; size < N; size += size) {
            for (int low = 0; low < N - size; low += size + size) {
                merge(a, aux, low, low + size - 1, Math.min(low + size + size - 1, N - 1));
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void bubbleSort(Comparable[] a) {
        int n = a.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (less(a[j + 1], a[j])) {
                    swap(a, j + 1, j);
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void bucketSort(int[] array, int bucketCount) {
        if(bucketCount <= 0) throw new IllegalArgumentException("Invalid bucket count");
        if(array.length <= 1){
            System.out.println(array);
            return;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if(max < array[i]){
                max = array[i];
            }
            if(min > array[i]) {
                min = array[i];
            }
        }
        double interval = ((double)(max - min + 1)) / bucketCount; //range of one bucket
        ArrayList<Integer>[] buckets = new ArrayList[bucketCount];

        System.out.println("interval: "  +  interval);

        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int i = 0; i < array.length; i++) {
            int index =  (int)((array[i] - min)/interval);
            System.out.println(index + " of " + array[i]);
            buckets[index].add(array[i]);
        }
        int pointer = 0;
        for (int i = 0; i < buckets.length; i++) {
            Collections.sort(buckets[i]);
            for (int j = 0; j < buckets[i].size(); j++) {
                array[pointer++] = buckets[i].get(j);
            }
        }
        System.out.println(Arrays.toString(array));

    }
}

class SortCompare {
    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("insertion")) Sorting.insertionSort(a);
        if (alg.equals("selection")) Sorting.selectionSort(a);;
        if (alg.equals("shell"))  Sorting.shell(a);
        if (alg.equals("merge"))  Sorting.mergeSort(a);
        if (alg.equals("quick"))  Sorting.quickSort(a);
        if (alg.equals("heap"))   Sorting.heap(a);
        if (alg.equals("bubble"))   Sorting.bubbleSort(a);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) { // Use alg to sort T random arrays of length N.
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) { // Perform one experiment (generate and sort an array).
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform();
            total += time(alg, a);
        }
        return total;
    }


    public static void main(String[] args) {
        double t1 = timeRandomInput("quick", 50000, 10); // total for alg1
        double t2 = timeRandomInput("insertion", 50000, 10);
        System.out.println("time used to sort using quick sort: " + t1);
        System.out.println("time used to sort using insertion sort: " + t2);
        StdOut.printf("For %d random Doubles\n %s is", 5000, "quick");
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, "insertion");


    }

/* double t1 = timeRandomInput("insertion", 5000, 10); // total for alg1
        double t2 = timeRandomInput("selection", 5000, 10);
        System.out.println("time used to sort using insertion: " + t1);
        System.out.println("time used to sort using selection " + t2);
        StdOut.printf("For %d random Doubles\n %s is", 5000, "insertion");
        StdOut.printf(" %.1f times faster than %s\n", t2/t1, "selection");*/
        /*Integer[] a = {4, 8, 1, 0, 2};
        Integer arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        Sorting.bubbleSort(a);*/
        /*double[] arr = {0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434, 0.48, 0.52, 0.11, 0.98};
*//*
        for(int i = 0; i < arr.length; i++) {
            System.out.println((int)Math.floor(arr[i]*arr.length));
        }*//*
        //Sorting.bucketSort(arr);
        Integer[] array = {4, 1, 0, 2, 3, -1, 0, 5, 7, 6, 11, 2};
        Sorting.shell(array);
        Sorting.insertionSort(array);*/

    /*    int[] arr = {22, 10, 13, 19, 85};
        Sorting.bucketSort(arr, 10);*/


    }




