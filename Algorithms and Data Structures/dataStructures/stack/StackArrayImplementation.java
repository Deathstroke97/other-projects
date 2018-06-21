package com.example.packages.dataStructures.stack;

import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class StackArrayImplementation<Item> implements Iterable<Item> {

    private Item[] a = (Item[])new Object[1];
    private int N = 0;

    public String toString(){
        return Arrays.toString(a);
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void resize(int newCap) {
        Item[] temp = (Item[])new Object[newCap];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;

    }

    public void push(Item item){
        if (N == a.length)
            resize(2 * a.length);
        a[N++] = item;

    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && a.length/4 == N )
            resize(a.length/2);
        return item;
    }

    public Item peek() {
        if(!isEmpty()){
            return a[N-1];
        }
        else{
            return null;
        }
    }
    public Iterator<Item> iterator() {

        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<Item>  {
        private int i = N;
        public boolean hasNext() {
            return i > 0;
        }
        public Item next() {
            return a[--i];
        }
        public void remove(){

        }
    }




}



































