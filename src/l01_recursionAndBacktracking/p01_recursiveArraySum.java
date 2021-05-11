package l01_recursionAndBacktracking;

import java.util.Scanner;

public class p01_recursiveArraySum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] n = scan.nextLine().split("\\s+");
        int[] numbers = new int[n.length];

        for (int i = 0; i < n.length; i++) {
            numbers[i] = Integer.parseInt(n[i]);
        }
        int sum;
        sum = sumNumbers(numbers, 0);

        System.out.println(sum);
    }

    private static int sumNumbers(int[] numbers, int index) {
        if (index >= numbers.length) {
            return 0;
        }
        return numbers[index] + sumNumbers(numbers, index + 1);
    }
}
