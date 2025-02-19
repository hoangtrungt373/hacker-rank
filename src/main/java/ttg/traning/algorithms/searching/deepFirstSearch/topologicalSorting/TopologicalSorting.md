# TopologicalSorting
Depth-First Search (DFS) is a graph traversal algorithm that explores as deep as possible along a branch before backtracking.

It is commonly used for:
* Finding connected components
* Solving mazes, puzzles (e.g., Sudoku)
* Pathfinding algorithms (e.g., Topological Sorting, Cycle Detection)
* Artificial intelligence (e.g., solving games)

#### Algorithm Steps
1. Start from a node (usually the root).
2. Visit the node and mark it as visited.
3. Recursively visit all its unvisited neighbors.
4. Backtrack if no unvisited neighbors are left.

DFS can be implemented in two ways:

* Recursive (Using function call stack)
* Iterative (Using an explicit stack)

#### Time Complexity
* Time Complexity: O(V + E) (V = vertices, E = edges)

#### Space Complexity
* Space Complexity: O(V) (for visited nodes)

#### UseCase
* When you need to explore all paths deeply first
* Works well with trees & graphs
* Used in Topological Sorting, Cycle Detection, and Solving Puzzles

❌ Not optimal for shortest path (use BFS instead)
❌ Recursive DFS can cause stack overflow for deep graphs
❌ Avoid for large datasets (better to use Binary Search if sorted).

