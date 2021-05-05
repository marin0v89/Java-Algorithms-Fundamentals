package l05_graphTheoryTraversalAndShortestPaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p03_shortestPath {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        int edges = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < edges; i++) {
            int[] paths = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            graph.get(paths[0]).add(paths[1]);
        }
        int source = Integer.parseInt(scan.nextLine());
        int destination = Integer.parseInt(scan.nextLine());

    }
}
