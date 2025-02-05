package ttg.traning.algorithms.searching.breadthFirstSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author ttg
 */
public class BreadthFirstSearch {
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    // Add edge (undirected)
    public void addEdge(int v, int w) {
        graph.putIfAbsent(v, new ArrayList<>());
        graph.putIfAbsent(w, new ArrayList<>());
        graph.get(v).add(w);
        graph.get(w).add(v);
    }

    // BFS function
    public void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " "); // Visit node

            for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
//            0
//          /   \
//         1     2
//        / \   / \
//       3   4 5   6
        BreadthFirstSearch g = new BreadthFirstSearch();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);

        System.out.print("BFS Traversal: ");
        g.bfs(0); // Start BFS from node 0
    }
}
