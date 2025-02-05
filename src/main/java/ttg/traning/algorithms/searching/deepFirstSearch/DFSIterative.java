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
public class DFSIterative {
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    // Add edge
    public void addEdge(int v, int w) {
        graph.putIfAbsent(v, new ArrayList<>());
        graph.putIfAbsent(w, new ArrayList<>());
        graph.get(v).add(w);
        graph.get(w).add(v);
    }

    // DFS using Stack
    public void dfs(int startNode) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited.contains(node)) {
                System.out.print(node + " ");
                visited.add(node);

                // Push neighbors to stack in reverse order to maintain proper order
                List<Integer> neighbors = graph.getOrDefault(node, Collections.emptyList());
                Collections.reverse(neighbors);
                for (int neighbor : neighbors) {
                    stack.push(neighbor);
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
        DFSIterative g = new DFSIterative();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);

        System.out.print("DFS Traversal: ");
        g.dfs(0);
    }
}