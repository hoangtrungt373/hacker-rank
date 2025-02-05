package ttg.traning.algorithms.searching.deepFirstSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author ttg
 */
public class DFSRecursive {
    private Map<Integer, List<Integer>> graph = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    // Add edge (undirected)
    public void addEdge(int v, int w) {
        graph.putIfAbsent(v, new ArrayList<>());
        graph.putIfAbsent(w, new ArrayList<>());
        graph.get(v).add(w);
        graph.get(w).add(v);
    }

    // DFS Recursive function
    public void dfs(int node) {
        if (visited.contains(node)) return;

        System.out.print(node + " "); // Visit node
        visited.add(node);

        for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
            dfs(neighbor);
        }
    }

    public static void main(String[] args) {
//            0
//          /   \
//         1     2
//        / \   / \
//       3   4 5   6
        DFSRecursive g = new DFSRecursive();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);

        System.out.print("DFS Traversal: ");
        g.dfs(0); // Start DFS from node 0
    }
}
