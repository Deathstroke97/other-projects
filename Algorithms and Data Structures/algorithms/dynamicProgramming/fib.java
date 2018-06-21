package com.example.packages.algorithms.dynamicProgramming;

class fib_solution {
    public static long fib(int n) {
        if (n == 0) return  0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }


    public static int fib_2(int n, int[] memo) {
        if (memo[n] != 0) return memo[n];
        int result;
        if (n == 1 || n == 2 ) {
            result = 1;
            return result;
        }
        else {
            result = fib_2(n - 1, memo) + fib_2(n - 2, memo);
            memo[n] = result;
        }
        return result;


    }

    public static long fib_3(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
    public static void main(String[] args) {
        int[] f = new int[100];
        System.out.println(fib_3(60));
        System.out.println(fib_2(60, f));
    }

}
