package l01_recursionAndBacktracking;

import java.util.Scanner;

public class p02_recursiveDrawing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        drawing(n);

    }

    private static void drawing(int n) {
        if (n == 0) {
            return;
        }
        printSymbols(n, '*');

        drawing(n - 1);

        printSymbols(n, '#');

    }

    private static void printSymbols(int n, char postfix) {
        for (int i = 0; i < n; i++) {
            System.out.print(postfix);
        }
        System.out.println();
    }
}
