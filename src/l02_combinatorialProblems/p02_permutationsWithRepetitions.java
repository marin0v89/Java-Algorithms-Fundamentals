package l02_combinatorialProblems;

import java.util.HashSet;
import java.util.Scanner;

public class p02_permutationsWithRepetitions {
    public static String[] elements;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        elements = scan.nextLine().split("\\s+");

        permute(0);
    }

    private static void permute(int index) {
        if (index == elements.length) {
            print(elements);
            return;
        }
        permute(index + 1);
        HashSet<String> swapped = new HashSet<>();
        swapped.add(elements[index]);
        for (int i = index + 1; i < elements.length; i++) {
            if (!swapped.contains(elements[i])) {
                swap(elements, index, i);
                permute(index + 1);
                swap(elements, index, i);
                swapped.add(elements[i]);
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
