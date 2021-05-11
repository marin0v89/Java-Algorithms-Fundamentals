package l03_recursionAndCombinatorialProblemExercise;

import java.util.*;
import java.util.stream.Collectors;

public class p08_wordCruncher {
    public static List<String> words;
    public static List<String> result = new ArrayList<>();
    public static String target;
    public static Set<String> output = new TreeSet<>();
    public static Map<Integer, List<String>> table = new HashMap<>();
    public static Map<String, Integer> counter = new HashMap<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        words = Arrays.stream(scan.nextLine().split(", "))
                .collect(Collectors.toList());
        target = scan.nextLine();
        words.removeIf(next -> !target.contains(next));

        for (String word : words) {
            counter.putIfAbsent(word, 0);
            counter.put(word, counter.get(word) + 1);
            int index = target.indexOf(word);

            while (index != -1) {
                table.putIfAbsent(index, new ArrayList<>());
                table.get(index).add(word);
                index = target.indexOf(word, index + 1);
            }
        }

        permute(0);
        for (String s : output) {
            System.out.println(s);
        }
    }

    private static void permute(int index) {
        if (index == target.length()) {
            print();
        } else if (table.containsKey(index)) {
            List<String> strings = table.get(index);
            for (String current : strings) {
                if (counter.get(current) > 0) {
                    counter.put(current, counter.get(current) - 1);
                    result.add(current);
                    permute(index + current.length());
                    result.remove(result.size() - 1);
                    counter.put(current, counter.get(current) + 1);
                }
            }
        }
    }

    private static void print() {
        String actual = String.join("", result);
        if (actual.contains(target)) {
            output.add(String.join(" ", result));
        }
    }
}
