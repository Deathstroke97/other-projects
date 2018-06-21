package com.example.packages.dataStructures.priorityQueue;
import java.util.*;

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;


    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key key) {
        pq[++N] = key;
        swim(N);
    }

    public Key deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        Key max = pq[1];
        swap(1, N--);
        sink(1, N);
        return max;

    }

    public boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    public void swap(int i, int j) {
        Key key = pq[i];
        pq[i] = pq[j];
        pq[j] = key;
    }

    public void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    public void sink(int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    public void content() {
        System.out.println(Arrays.toString(pq));
    }

    public void heapSort() {
        int N = pq.length - 1;

        for (int k = N / 2; k >= 1; k--)
            sink(k, N);
        while (N > 1) {
            swap(1, N--);
            sink(1, N);
        }
        System.out.println(Arrays.toString(pq));
    }

    public boolean isMaxHeap() {
        return isMaxHeap(1);
    }

    public boolean isMaxHeap(int k) {
        if (k > N) return true;

        if (2 * k <= N && pq[k].compareTo(pq[2 * k]) < 0) return false;
        if (2 * k + 1 <= N && pq[k].compareTo(pq[2 * k + 1]) < 0) return false;

        return isMaxHeap(k * 2) && isMaxHeap(k * 2 + 1);

    }
}
