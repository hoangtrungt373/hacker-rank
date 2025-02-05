# TimSort
Linear Search is the simplest searching algorithm. It checks each element one by one until it finds 
the target value or reaches the end of the list.

#### Algorithm Steps
1. Start from the first element.
2. Compare each element with the target value.
3. If found, return the index.
4. If not found, return -1.

#### Time Complexity
* Best case: O(1) (first element is the target)
* Worst case: O(n)
* Average case: O(n) (target is last or not present)

#### Space Complexity
* Space Complexity: O(1) (no extra memory used)
*  Works on sorted and unsorted data

#### UseCase
* Best for small datasets or unsorted data.
* Works with all types of data structures (arrays, linked lists, etc.).
* No extra memory needed (O(1) space).

❌ Avoid for large datasets (better to use Binary Search if sorted).

