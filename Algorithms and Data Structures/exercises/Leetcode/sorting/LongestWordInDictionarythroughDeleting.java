package com.example.packages.exercises.Leetcode.sorting;
import java.util.*;

public class LongestWordInDictionarythroughDeleting {

    public static String smallestLexicographicalOrder(List<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o2.length() - o1.length();
            }
        });
        return list.get(0);
    }



    public static boolean hasAllOccurences(Map<Character, Integer> map, String str) {
        Map<Character, Integer> temp = new HashMap<Character, Integer>(map);
        boolean bool = true;
        char[] data = str.toCharArray();
        for (int i = 0; i < data.length; i++) {
            if (!temp.containsKey(data[i]) || temp.get(data[i]) <= 0) {
                bool = false;
                break;
            }
            temp.put(data[i], temp.get(data[i]) - 1);
        }
            return bool;
    }

    public static String findLongestWord(String s, List<String> d) {
        List<String> result = new ArrayList<>();
        char[] dataS = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < dataS.length; i++) {
            if (!map.containsKey(dataS[i])) {
                map.put(dataS[i], 1);
            }
            map.put(dataS[i], map.get(dataS[i]) + 1);
        }
        for (String str : d) {
            boolean bool = hasAllOccurences(map, str);
            if (bool == true) {
                result.add(str);
            }
        }
        if (result.isEmpty()) {
            return "";
        }
        if (result.size() == 1) {
            return result.get(0);
        }
        else{
            return smallestLexicographicalOrder(result);
        }
    }

    public static void main(String[] args) {
        String s = "aewfafwafjlwajflwajflwafj";
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("ewaf");
        list.add("awefawfwaf");
        list.add("awef");
        list.add("awefe");
        list.add("ewafeffewafewf");
        System.out.println(findLongestWord(s, list));

    }
}


class RightSolution2 {
    public static String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o2.length() == o1.length()) {
                    return o1.compareTo(o2);
                }
                return o2.length() - o1.length();
            }
        });
        char[] sArr = s.toCharArray();
        System.out.println("List :" + d);
        for (String word : d) {
            if (canForm(sArr, word.toCharArray())) {
                return word;
            }
        }
        return "";
    }

    private static boolean canForm(char[] s, char[] word) {
        int wi = 0, si = 0;
        while (wi < word.length && si < s.length) {
            if (word[wi] == s[si]) {
                wi++;
                si++;
            } else {
                si++;
            }
        }
        return wi == word.length;
    }
    public static void main(String[] args) {
        String s = "aewfafwafjlwajflwajflwafj";
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("ewaf");
        list.add("awefawfwaf");
        list.add("awef");
        list.add("awefe");
        list.add("ewafeffewafewf");
        System.out.println(findLongestWord(s, list));

    }
}








