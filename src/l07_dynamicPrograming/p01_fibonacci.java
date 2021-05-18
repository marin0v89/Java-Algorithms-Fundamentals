package l07_dynamicPrograming;

import java.util.Scanner;

public class p01_fibonacci {
    public static long[] dp;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        dp = new long[n + 1];

        long fib = calcFib(n);
        System.out.println(fib);
    }

    private static long calcFib(int n) {
        if (n <= 2) {
            return 1;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = calcFib(n - 1) + calcFib(n - 2);
    }
}
