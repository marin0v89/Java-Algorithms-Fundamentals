package l03_recursionAndCombinatorialProblemExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p02_nestedLoopsToRecursion {

    public static int[] arr;
    public static int limit;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        limit = Integer.parseInt(reader.readLine());
        arr = new int[limit];

        loopRecursion(0);
    }

    private static void loopRecursion(int index) {
        if (index == arr.length) {
            print();
        } else {
            for (int i = 1; i <= limit; i++) {
                arr[index] = i;
                loopRecursion(index + 1);
            }
        }
    }

    private static void print() {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
