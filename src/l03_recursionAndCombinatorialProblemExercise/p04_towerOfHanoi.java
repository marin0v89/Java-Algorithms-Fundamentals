package l03_recursionAndCombinatorialProblemExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.stream.Collectors;

public class p04_towerOfHanoi {
    public static StringBuilder sb = new StringBuilder();

    public static Deque<Integer> source = new ArrayDeque<>();
    public static Deque<Integer> spare = new ArrayDeque<>();
    public static Deque<Integer> destination = new ArrayDeque<>();

    public static int steps = 1;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        for (int i = n; i >= 1; i--) {
            source.push(i);
        }
        printRods();
        towerOfHanoi(n, source, destination, spare);

        System.out.println(sb.toString().trim());
    }

    private static void towerOfHanoi(int disk, Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {
        if (disk == 1) {
            destination.push(source.pop());
            sb
                    .append("Step #")
                    .append(steps++)
                    .append(": Moved disk")
                    .append(System.lineSeparator());
            printRods();
        } else {
            towerOfHanoi(disk - 1, source, spare, destination);
            towerOfHanoi(1, source, destination, spare);
            towerOfHanoi(disk - 1, spare, destination, source);
        }
    }

    public static void printRods() {
       sb.append(String.format("Source: %s%nDestination: %s%nSpare: %s%n"
                , formatRod(source)
                , formatRod(destination)
                , formatRod(spare)))
       .append(System.lineSeparator());
    }

    private static String formatRod(Deque<Integer> stack) {
        return stack.stream()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
