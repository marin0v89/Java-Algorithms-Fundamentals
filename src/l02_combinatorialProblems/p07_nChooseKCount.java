package l02_combinatorialProblems;

import java.util.Scanner;

public class p07_nChooseKCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int k = Integer.parseInt(scan.nextLine());

        int binom = binom(n, k);
        System.out.println(binom);

    }

    private static int binom(int n, int k) {
        if (k > n) {
            return 0;
        }
        if (k == 0 || k == n) {
            return 1;
        }
        return binom(n - 1, k - 1) + binom(n - 1, k);
    }
}
