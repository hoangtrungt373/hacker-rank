# BinarySearch
Binary Search is a divide-and-conquer algorithm that finds an element only in a sorted array by 
repeatedly dividing the search space in half.

#### Algorithm Steps
1. Find the middle element of the array.
2. Compare it with the target value:
* If the middle element matches the target, return its index.
* If the target is smaller, search in the left half.
* If the target is greater, search in the right half.
6. Repeat until the element is found or the search space becomes empty.

#### Time Complexity
* Best case: O(1) (middle element is the target)
* Worst case: O(log n)
* Average case: O(log n)

#### Space Complexity
* Space Complexity: O(1) for iterative approach (constant space). O(log n) for recursive approach (stack space).
* Only works on sorted arrays.

#### UseCase
* Best for searching in sorted arrays.
* Much faster than Linear Search (O(log n) vs O(n)).
* Works well for large datasets.

❌ Doesn't work on unsorted arrays (must be sorted first).

❌ Not efficient for small datasets (Linear Search might be better).

