package com.example.packages.dataStructures.priorityQueue;
import java.util.*;

public class MinPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;


    public MinPQ(int maxN) {
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

    public Key deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow! ");
        Key min = pq[1];
        swap(1, N--);
        sink(1, N);
        return min;
    }

    public boolean greater(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    public void swap(int i, int j) {
        Key key = pq[i];
        pq[i] = pq[j];
        pq[j] = key;
    }

    public void swim(int k) {
        while (k > 1 && greater(k / 2 , k )) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    public void sink(int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && greater(j, j + 1 )) {
                j++;
            }
            if (!greater(k, j))
                break;
            swap(j, k);
            k = j;
        }
    }

    public void contentOfMinPQ() {
        System.out.println("MinPQ: " + Arrays.toString(pq));
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

    public boolean isMinHeap() {
        return isMinHeap(1);
    }

    public boolean isMinHeap(int k) {
        if (k > N) return true;

        if (2 * k <= N && pq[2 * k].compareTo(pq[k]) < 0) return false;
        if (2 * k + 1 <= N && pq[2 * k + 1].compareTo(pq[k]) < 0) return false;

        return isMinHeap(k * 2) && isMinHeap(k * 2 + 1);

    }
    public static void main(String[] args) {
        MinPQ<Integer> pq = new MinPQ<>(7);
            pq.insert(9);
            pq.insert(4);
            pq.insert(11);
            pq.insert(-1);
            pq.insert(5);
            pq.insert(6);
            pq.insert(2);


        pq.contentOfMinPQ();
        System.out.println("Min: " + pq.deleteMin());
        System.out.println("Min: " + pq.deleteMin());
        System.out.println("Min: " + pq.deleteMin());
        pq.heapSort();
    }
}
