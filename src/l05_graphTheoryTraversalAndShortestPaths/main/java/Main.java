package l05_graphTheoryTraversalAndShortestPaths.main.java;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String nextLine = scan.nextLine();
            if (nextLine.trim().equals("")){
                graph.add(new ArrayList<>());
            }else {
                List<Integer> nextNodes = Arrays.stream(nextLine.split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                graph.add(nextNodes);
            }
        }
        System.out.println();
    }

    public static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {
        List<Deque<Integer>> components = new ArrayList<>();
        visited = new boolean[graph.size()];

        for (int start = 0; start < graph.size(); start++) {
            if (!visited[start]) {
                Deque<Integer> current = new ArrayDeque<>();
                //dfs(start, graph, current);
                components.add(current);
            }
        }


        return components;
    }

    public static Collection<String> topSort(Map<String, List<String>> graph) {
        throw new AssertionError("Not Implemented");
    }
}
