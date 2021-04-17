package l01_recursionAndBacktracking;

import java.util.Scanner;

public class p03_generatingVectors {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Integer[] numbers = new Integer[n];

        vectors(numbers, 0);
    }

    private static void vectors(Integer[] numbers, int index) {
        if (index >= numbers.length) {
            print(numbers);
            return;
        }
        for (int i = 0; i <= 1; i++) {
            numbers[index] = i;
            vectors(numbers, index + 1);
        }
    }

    private static void print(Integer[] numbers) {
        for (Integer number : numbers) {
            System.out.print(number);
        }
        System.out.println();
    }
}
