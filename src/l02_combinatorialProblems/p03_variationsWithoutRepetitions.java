package l02_combinatorialProblems;

import java.util.HashSet;
import java.util.Scanner;

public class p03_variationsWithoutRepetitions {
    public static String[] elements;
    public static String[] variations;
    public static boolean[] used;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        elements = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(scan.nextLine());
        variations = new String[n];

        used = new boolean[elements.length];

        variations(0);
    }

    private static void variations(int index) {
        if (index == variations.length) {
            print(variations);
            return;
        }
        for (int i = 0; i < elements.length; i++) {
            if (!used[i]) {
                used[i] = true;
                variations[index] = elements[i];
                variations(index + 1);
                used[i] = false;
            }
        }
    }

    private static void swap(String[] arr, int first, int second) {
        String temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static void print(String[] elements) {
        System.out.println(String.join(" ", elements));
    }
}
