package l03_recursionAndCombinatorialProblemExercise;

import java.util.Scanner;

public class p03_combinationsWithRepetition {
    public static int[] arr;
    public static int n;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = Integer.parseInt(scan.nextLine());
        int k = Integer.parseInt(scan.nextLine());

        arr = new int[k];

        combinations(0, 1);
    }

    private static void combinations(int index, int start) {
        if (index == arr.length) {
            print();
        } else {
            for (int i = start; i <= n; i++) {
                arr[index] = i;
                combinations(index + 1, i);
            }
        }
    }

    private static void print() {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
