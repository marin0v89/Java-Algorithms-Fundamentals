package l01_recursionAndBacktracking;

import java.util.Scanner;

public class p05_recursiveFibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        System.out.println(fib(n));
    }

    private static int fib(int n) {
        if (n <= 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
