package com.example.packages.exampleCodes;
import com.example.packages.stdlib.*;

import java.io.FileInputStream;
import java.util.*;
import java.io.*;

public class TwoSumFast {
    public static int binarySearch(int a, int[] array, int low, int  high) {
        int middle = (int)Math.floor((low+high)/2);
        if(low > high)
            return -1;
        else if(array[middle] == a)
            return middle;
        else if(array[middle] > a)
            return binarySearch(a, array, low, middle - 1);
        else
            return binarySearch(a, array, middle + 1, high);
    }

    public static int count(int[] a) {
        Arrays.sort(a);
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (binarySearch(-a[i], a, 0, a.length - 1) > i) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
    /*int[] a = In.readInts("C:\\Users\\Aзат\\IdeaProjects\\exercises\\
    src\\com\\example\\packages\\exampleCodes\\numbers.txt");
    StdOut.println(count(a));*/

        File file = new File("C:\\Users\\Aзат\\IdeaProjects\\exercises" +
                "\\src\\com\\example\\packages\\exampleCodes\\numbers.txt");

        List<Integer> arrayList =  new ArrayList<Integer>();
        if(file.exists()){
            int myArray[];
            Scanner inFile = null;
            try{
                inFile = new Scanner(file);
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
            }
            while(inFile.hasNext()){
                arrayList.add(inFile.nextInt());

            }
            myArray = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++ )
                myArray[i] = arrayList.get(i).intValue();

            System.out.println(Arrays.toString(myArray));
            System.out.println(count(myArray));

        }
        else{
            System.out.println("file not found");
        }
    }
}

