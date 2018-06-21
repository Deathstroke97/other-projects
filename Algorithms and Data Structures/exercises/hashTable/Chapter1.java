package com.example.packages.exercises.hashTable;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.*;
class LinearProbingHashST<Key, Value> {
    private int N;
    private int M = 16;
    private Key[] keys;
    private Value[] vals;

    LinearProbingHashST(int newCap) {
        M = newCap;
        keys = (Key[])new Object[M];
        vals = (Value[]) new Object[M];
    }
    public int hash(Key key) {
        return (key.hashCode() & 0xfffffff) % M;
    }
    public void resize(int newCap) {
        LinearProbingHashST<Key, Value> t = new LinearProbingHashST<>(newCap);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null)
                t.put(keys[i], vals[i]);
        }
        keys = t.keys;
        vals = t.vals;
    }
    public void put(Key key, Value val) {
        if (N >= M/2) resize(2 * M);
        int i;
        for( i = hash(key); keys[i] != null; i = (i + 1) % M){
            if(keys[i].equals(key)){
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key) {
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }

    public void delete(Key key) {
        if(!contains(key)) return;
        int i = hash(key);
        while(!keys[i].equals(key)){
            i = (i + 1) % M;
        }
        keys[i] = null;
        vals[i] = null;
        N--;
        i = (i + 1) % M;
        while(keys[i] == null){
            Key k = keys[i];
            Value v = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(k, v);
            i = (i + 1) % M;
        }
        if(N > 0 && N == M / 8)
            resize(M / 2);
    }

    public boolean contains(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if(keys[i].equals(key)){
                return true;
            }
        }
        return false;
    }

}
public class Chapter1 {

    public static boolean isUnique(String string) {

        String[] words = string.toLowerCase().split("");
        System.out.println(words.length);
        System.out.println(string.length());
        LinearProbingHashST<String, Integer> st = new LinearProbingHashST<>(string.length());

        int i = 0;
        for (int j = 0; j < words.length; j++) {
            if (st.get(words[j]) == null) {
                st.put(words[j], 1);
                i++;
            }
        }
        if (i == words.length) {
            return true;
        } else {
            return false;
        }
    }

        public static boolean isUnique2(String string) {
            String[] words = string.toLowerCase().split("");
            for (int i = 0; i < words.length; i++ ) {
                for(int j = 0; j < words.length; j++ ) {
                    if(i == j){
                        continue;
                    }
                    if(words[i].equals(words[j])){
                        return false;
                    }
                }
            }
        return true;
    }

    public static String reverse(String input) {
        char data[] = input.toCharArray();
        int begin = 0;
        int end = data.length - 1;

        while(begin < end) {
            char temp = data[begin];
            data[begin] = data[end];
            data[end] = temp;
            begin++;
            end--;

        }
        String string = new String(data);
        return string;
    }

    public static String withOutDuplicates(String input) {
        char[] data = input.toCharArray();
        int firstOccurenceIndex = 0;
        int lastOccurenceIndex = 0;

        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if(data[i]==' '&& data[j] == ' '){
                    continue;
                }
                if (data[i] == data[j]) {
                    firstOccurenceIndex = j;

                    while (data[i] == data[j] && j < data.length) {
                        lastOccurenceIndex = j;
                        data[j] = ' ';
                        j++;
                        if (lastOccurenceIndex == data.length){
                            while(firstOccurenceIndex < data.length){
                                data[++firstOccurenceIndex] = ' ';
                            }
                            String string = new String(data);
                            return string;
                        }
                    }


                    if (lastOccurenceIndex == data.length){
                        while(firstOccurenceIndex < data.length){
                            data[++firstOccurenceIndex] = ' ';
                        }
                        String string = new String(data);
                        return string;
                    }
                    else {
                        lastOccurenceIndex = lastOccurenceIndex + 1;
                        while (lastOccurenceIndex < data.length) {
                            char temp = data[firstOccurenceIndex];
                            data[firstOccurenceIndex] = data[lastOccurenceIndex];
                            data[lastOccurenceIndex] = temp;
                            firstOccurenceIndex++;
                            lastOccurenceIndex++;
                        }
                        //data[data.length - 1] = ' ';
                    }
                }
            }
        }

        String string = new String(data);
        return string;

    }

    public static String removeDuplicateCharacters(String word) {
        //Objects.requireNonNull(word);

        char[] wordArray = word.toCharArray();

        int len = wordArray.length;
        for (int i = 0; i < wordArray.length; i++) {
            int count = 0;
            for (int j = i; j < wordArray.length; j++) {
                if (wordArray[i] == wordArray[j]) {
                    count++;
                    if (count > 1) {
                        wordArray[j] = 0;
                    }
                }
            }
        }
        return String.valueOf(wordArray);
    }

    public static void removeDuplicatesEff(char[] str) {
         if (str == null) return;
         int len = str.length;
         if (len < 2) return;
         boolean[] hit = new boolean[256];
         for (int i = 0; i < 256; ++i) {
             hit[i] = false;
         }
         hit[str[0]] = true;
         int tail = 1;
         for (int i = 1; i < len; ++i) {
             if (!hit[str[i]]) {
                 str[tail] = str[i];
                 ++tail;
                 hit[str[i]] = true;
                 }
             }
         str[tail] = 0;
         String string = new String(str);
        System.out.println(string);
         }

     public static void myWayOfDeletingDuplicates(String string) {
        char[] data = string.toCharArray();
        char[] result = new char[data.length];
        boolean[] hit = new boolean[256];
        int j = 0;
        for(int i = 0; i < data.length; i++) {
            if(!hit[data[i]]){
                result[j] = data[i];
                j++;
                hit[data[i]] = true;
            }
        }
        String str = new String(result);
         System.out.println(str);

     }

     static boolean areAnagram(char[] str1, char[] str2) {
        int length1 = str1.length;
        int length2 = str2.length;
        if(length1 != length2)
            return false;
        quickSort(str1, 0, length1 - 1);
        quickSort(str2, 0, length2 - 1);
         //System.out.println(str1);
         // System.out.println(str2);

        for(int i = 0; i < length1; i++) {
            if(str1[i] != str2[i]){
                return false;
            }
         }
         return true;
     }

     static void quickSort(char[] data, int low, int high) {
        if (low < high) {
            int p = partition(data, low, high);
            quickSort(data, low, p - 1);
            quickSort(data, p + 1, high);
        }


     }

     static int partition(char[] data, int low, int high) {
        int divider = 0;
        char pivot = data[high];
        for (int i = 0; i < high; i++) {
            if(data[i] < pivot) {
                char temp = data[divider];
                data[divider] = data[i];
                data[i] = temp;
                divider++;
            }
        }
        char temp = data[divider];
        data[divider] = pivot;
        data[high] = temp;
        return divider;
     }

       public static void ReplaceFun(char[] str, int length) {
        int spaceCount = 0, newLength, i = 0;
        for (i = 0; i < length; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        newLength = length + spaceCount * 2;
           System.out.println(newLength);
        str[newLength] = '\0';
         for (i = length - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength = newLength - 3;
            }
            else {
                str[newLength - 1] = str[i];
                newLength = newLength - 1;
                }
         }
           System.out.println(String.valueOf(str));
         }






    public static void replaceSpaces(char[] str, int length) {
        int spaceCount = 0, newLength = 0, i = 0;

        for(i = 0; i < length; i++) {
            if (str[i] == ' ')
                spaceCount++;
        }

        newLength = length + (spaceCount * 2);
        str[newLength] = '\0';
        for(i = length - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength = newLength - 3;
            }
            else {
                str[newLength - 1] = str[i];
                newLength = newLength - 1;
            }
        }
        System.out.println(str);
    }

    public static void setToZeroUtil(int[][] arr, int m, int n) {
        for (int j = 0; j < arr[m].length; j++) {
            arr[m][j] = 0;
        }
        for(int i = 0; i < arr.length; i++) {
            if((arr[i].length - 1) >=  n){
                arr[i][n] = 0;
            }
        }
    }

    public static void setToZero(int[][] arr) {

        for(int i = 0; i < arr.length; i++ ) {
            for(int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == 0)
                    setToZeroUtil(arr, i, j);
                }
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }





    public static void main(String[] args) {
       /* char[] str1 = new String("listen listen azat").toCharArray();
        char[] str2 = new String("silent").toCharArray();
        // quickSort(data, 0, data.length - 1 );
        //System.out.println(areAnagram(str1, str2));
        //ReplaceFun(str1, str1.length);
        char[] ch = {'t', 'h', 'e', ' ', 'd', 'o', 'g', ' ', ' ', ' ', ' ', ' ', ' '};
        int length = 6;
        replaceSpaces(ch, ch.length);
*/
       int[][] myArray = {{1, 2, 0}, {5, 4, 7}, {4, 1, 8, 2}};
       setToZero(myArray);

    }

}
