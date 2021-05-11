package l03_recursionAndCombinatorialProblemExercise;

import java.util.Arrays;
import java.util.Scanner;

public class p01_reverseArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        reversed(numbers, 0, numbers.length - 1);
    }

    private static void reversed(int[] numbers, int i, int j) {
        if (i < j) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
            reversed(numbers, ++i, --j);
        } else {
            for (int number : numbers) {
                System.out.print(number + " ");
            }
        }
    }
}
