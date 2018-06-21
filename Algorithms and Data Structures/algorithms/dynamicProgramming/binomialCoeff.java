package com.example.packages.algorithms.dynamicProgramming;

class Solution {
    public static long binomialCoeff_1(int n, int k) {
        if (k == 0 || n == k) {
            return 1;
        }
        return binomialCoeff_1(n - 1, k - 1) + binomialCoeff_1(n - 1, k);

    }
    //naive recursive solution

    public static long binomialCoeff_2(int n, int k) {
        int[][] C = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int  j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i) {
                    C[i][j] = 1;
                }
                else {
                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
                }
            }
        }
        return C[n][k];
    }
    //dynamic programming based solution
    public static void main(String[] args) {
       long r = binomialCoeff_2(5, 3);
        System.out.println(r);
    }

}
