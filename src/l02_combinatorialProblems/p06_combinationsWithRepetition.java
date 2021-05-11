package l02_combinatorialProblems;

import java.util.Scanner;

public class p06_combinationsWithRepetition {
    public static String[] elements;
    public static String[] variations;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        elements = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(scan.nextLine());
        variations = new String[n];

        combinations(0, 0);
    }

    private static void combinations(int index, int start) {
        if (index == variations.length) {
            print(variations);
        } else {
            for (int i = start; i < elements.length; i++) {
                variations[index] = elements[i];
                combinations(index + 1, i);
            }
        }
    }


    private static void print(String[] elements) {
        System.out.println(String.join(" ", elements));
    }
}
