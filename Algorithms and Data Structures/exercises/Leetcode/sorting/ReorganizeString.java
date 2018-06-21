package com.example.packages.exercises.Leetcode.sorting;
import java.util.*;

class MultiChar {
    int count;
    char letter;
    MultiChar(int count, char letter) {
        this.count = count;
        this.letter = letter;
    }
    @Override
    public String toString() {
        return letter + " -" + count;
    }
}

class MultiCharComparator implements Comparator<MultiChar> {
    public int compare(MultiChar a, MultiChar b) {
        return a.count == b.count ? a.letter - b.letter : b.count - a.count;
    }
}
public class ReorganizeString {

    public static String reorganizeString(String S) {
        int N = S.length();
        int[] count = new int[26];
        for (char c: S.toCharArray()) count[c-'a']++;
        PriorityQueue<MultiChar> pq = new PriorityQueue<MultiChar>((a, b) ->
                a.count == b.count ? a.letter - b.letter : b.count - a.count);

        for (int i = 0; i < 26; ++i) if (count[i] > 0) {
            if (count[i] > (N + 1) / 2) return "";
            pq.add(new MultiChar(count[i], (char) ('a' + i)));
        }

        StringBuilder ans = new StringBuilder();
        while (pq.size() >= 2) {
            MultiChar mc1 = pq.poll();
            MultiChar mc2 = pq.poll();
            /*This code turns out to be superfluous, but explains what is happening
            if (ans.length() == 0 || mc1.letter != ans.charAt(ans.length() - 1)) {
                ans.append(mc1.letter);
                ans.append(mc2.letter);
            } else {
                ans.append(mc2.letter);
                ans.append(mc1.letter);
            }*/
            ans.append(mc1.letter);
            ans.append(mc2.letter);
            if (--mc1.count > 0) pq.add(mc1);
            if (--mc2.count > 0) pq.add(mc2);
        }

        if (pq.size() > 0) ans.append(pq.poll().letter);
        return ans.toString();
}

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
    }
}
