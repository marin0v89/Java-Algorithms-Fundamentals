package l06_graphTheoryTraversalAndShortestPaths_Exercise;

import java.util.*;

public class p03_cyclesInGraph {
    public static Map<String, List<String>> graph = new HashMap<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();
        String source = null;
        while (!("End").equals(line)) {

            String[] tokens = line.split("-");
            if (source == null) {
                source = tokens[0];
            }
            graph.putIfAbsent(tokens[0], new ArrayList<>());
            graph.get(tokens[0]).add(tokens[1]);

            line = scan.nextLine();
        }
        Set<String> visited = new HashSet<>();
        Set<String> cycles = new HashSet<>();

        try {
            dfs(source, visited, cycles);
            System.out.println("Acyclic: Yes");

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void dfs(String source, Set<String> visited, Set<String> cycles) {
        if (cycles.contains(source)) {
            throw new IllegalStateException("Acyclic: No");
        }
        if (visited.contains(source)) {
            return;
        }
        cycles.add(source);
        visited.add(source);
        List<String> children = graph.get(source);

        if (children == null) {
            return;
        }

        for (String child : children) {
            dfs(child, visited, cycles);
        }
        cycles.remove(source);
    }
}
