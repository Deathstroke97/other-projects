package com.example.packages.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class BitManipulation {

    public static boolean isPowerOfTwo(int x) {
        int result = x & (x -1);
        if(result == 0 && x != 0) {
            return true;
        }
        return false;
    }

    public static boolean isSet(int n, int i) {
        int  b = n & (1 << i);
        if (b == 0)
            return false;
        return true;
    }

    public static <T>void possibleSubSets(T[] set) {
        int n = set.length;
        for (int i = 0; i < (1 << n); i++) {
            System.out.print("{");

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    System.out.print(set[j] + " ");
                }
            }
            System.out.println("}");
        }
    }

    public static void setBits(int N, int M, int i, int j) {
        int max = ~0;
        int left = max - ((1 << j) -1);
        int right = (1 << i) - 1;
        int mask = left | right;

        System.out.println((N & mask) | (M <<i));
    }

    public static void requiredBits(int x, int y) {
        int n = 0, m = 0;
        while(x != 0) {
            x = x & (x - 1);
            n++;
        }
        while(y != 0) {
            y = y & (y - 1);
            m++;
        }
        System.out.println(Math.abs(n-m));
    }

    public static String toBinary(int n) {
        String str = new String();
        while(n != 0) {
            int remainder = n % 2;
            str = Integer.toString(remainder) + str;
            n = n>>1;
        }
        return str;
    }

    public static String printBinary(String n) {
        int intPart = Integer.parseInt(n.substring(0, n.indexOf('.')));
        double decimalPart = Double.parseDouble(n.substring(n.indexOf('.'), n.length()));


        String int_string = "";
        while (intPart > 0) {
            int r = intPart % 2;
            intPart >>= 1;
            int_string = r + int_string;
        }
        StringBuffer dec_string = new StringBuffer();
        while(decimalPart > 0) {
            if (dec_string.length() > 32) return "ERROR";
            if (decimalPart == 1) {
                dec_string.append('1');
                break;
            }
            double r = decimalPart * 2;
            if(r >= 1 ){
                dec_string.append('1');
                decimalPart = decimalPart - 1;
            }
            else{
                dec_string.append('0');
                decimalPart = r;
            }
        }
        String result = int_string + "." + dec_string;
        return result;

    }

    public static void nextLargest(String str) {
        char[] data = str.toCharArray();
        if(str.indexOf('0') == -1) {
            System.out.println("it is max itself!");
            return;
        }
        for (int i = data.length - 1; i >= 0; i-- ) {
            if(data[i] == '0'){
                if(data[i - 1] == '0'){
                    data[i] = '1';
                    data[i+1] = '0';
                    System.out.println("Next largest: " + new String(data));
                    break;
                }
                if(i == data.length - 1){
                    data[i] = '1';
                    System.out.println("Next largest: " + new String(data));
                    break;
                }
                data[i] = '1';
                data[i + 1] = '0';
                System.out.println("Next largest: " + new String(data));
                break;
            }
        }

    }

    public static void nextSmallest(String str) {
        char[] data = str.toCharArray();
        if (str.indexOf('0') == -1){
            System.out.println("No smaller than given number! ");
        }
        for (int i = data.length - 1; i >=0 ; i--) {
            if (data[i] == '0' && data[i - 1] == '0') {
                continue;
            }
            if(data[i] == '0') {
                data[i] = '1';
                data[i - 1] = '0';
                System.out.println("Next Smallest: " + new String(data));
                break;
            }

        }
    }

    public static void swapBits(String str) {
        char[] data = str.toCharArray();
        for (int i = data.length - 1; i > 0; i--) {
            char temp = data[i];
            data[i] = data[--i];
            data[i] = temp;


        }
        System.out.println(new String(data));
    }

    public static double fromBinaryToDecimal(String str) {
        char[] data = str.toCharArray();

        double result = 0;
        int j = 0;
        for(int i =  data.length - 1; i >= 0; i--) {
            int current = Character.getNumericValue(data[i]);
            if(current != 0) {
                result = result + (current * Math.pow(2, j));
            }
            j++;
        }
        return result;
    }
    public static double fetchBit(String binary, int ithBit) {
        char[] data = binary.toCharArray();
        int index = data.length - 1 - ithBit;
        return Character.getNumericValue(data[index]) * Math.pow(2, ithBit);
    }
    public static int missingNumber(String[] data) {
        int[] arr = new int[data.length + 2];
        int missing = 0;
        for (int i = 0; i < data.length; i++) {
            int intValue = 0;
            for (int j = 0; j < data[i].length(); j++) {
                intValue += fetchBit(data[i], j);

            }
            arr[intValue] = intValue;
        }
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == 0){
                missing = i;
                break;
            }
        }
        return missing;
    }

    public static int swapOddEvenBits(int x) {
        return (((x & 0xAAAAAAAA) >>1 ) | ((x & 0x55555555)<<1));
    }


    public static void main(String[] args) {
        //System.out.println(isSet(20, 2));
        System.out.println(isPowerOfTwo(2));
        //System.out.println(1 << 2);
        //Integer[] set = {1, 2, 3, 4, 5, 6};
        //possibleSubSets(set);
        //setBits(1024, 21, 2, 6);
        //requiredBits(31, 14);
        //System.out.println(printBinary("3.25"));
        //System.out.println("Your number: " + toBinary(5));
        //nextLargest(toBinary(31));
        //nextSmallest(toBinary(5));
        //swapBits(toBinary(21));
        //System.out.println(fromBinaryToDecimal("11010"));
        //System.out.println(fetchBit("11010", 3));
          //String[] string = {"001", "010", "011", "100", "101", "111"};
          //System.out.println("Missing Number: "+ missingNumber(string));

       // System.out.println(23);


    }

}
