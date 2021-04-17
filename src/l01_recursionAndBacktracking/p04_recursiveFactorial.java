package l01_recursionAndBacktracking;

import java.util.Scanner;

public class p04_recursiveFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        long result = calculateFactorial(n);
        System.out.println(result);
    }

    private static long calculateFactorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * calculateFactorial(n - 1);
    }
}
