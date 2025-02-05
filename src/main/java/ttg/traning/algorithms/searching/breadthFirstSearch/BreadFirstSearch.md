# DeepFirstSearch
Breadth-First Search (BFS) is a graph traversal algorithm that explores all neighbors first before moving to their children. 
It is best suited for finding the shortest path in an unweighted graph.

#### Algorithm Steps
1. Start from a source node.
2. Visit the node and mark it as visited.
3. Add all unvisited neighbors to a queue.
4. Process each node in the queue one by one.
5. Repeat until all reachable nodes are visited.

#### Time Complexity
* Time Complexity: O(V + E) (V = vertices, E = edges)

#### Space Complexity
* Space Complexity: O(V) (for visited nodes & queue)

#### UseCase
* When searching for the shortest path in an unweighted graph
* When exploring all neighbors first
* Best for solving maze problems & finding connected components

❌ Consumes more memory (O(V)) than DFS due to queue storage

❌ Slower than DFS for deep graphs
