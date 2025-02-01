# QuickSort
Quick Sort is a divide and conquer sorting algorithm that:
1. Selects a pivot element.
2. Partitions the array such that elements smaller than the pivot are placed on the left, and elements greater than the pivot are placed on the right.
3. Recursively sorts the left and right sub-arrays.

#### Algorithm Steps
* Choose a pivot (typically the last element, first element, or a random element).
* Partition the array:
Move all elements smaller than the pivot to the left. 
Move all elements greater than the pivot to the right.
* Recursively apply Quick Sort to the left and right sub-arrays.

#### Time Complexity
* Best case (already sorted): 𝑂(𝑛 log n)
* Worst case (reversed list): 𝑂(𝑛2)
* Average case: 𝑂(𝑛 log n)

#### Space Complexity
* Space Complexity: O(log n) (due to recursion stack).
* Not Stable (relative order of equal elements may change).

#### UseCase
* Fastest for average cases (O(n log n)).
* Efficient for large datasets with random distribution.
* In-place sorting (requires O(log n) extra space).
* Used in standard library implementations (like Java's Arrays.sort() for primitives).

❌ Avoid Quick Sort if:

* Worst-case O(n²) performance is a concern (e.g., when the array is already sorted, and a bad pivot is chosen).
* You need a stable sort (Quick Sort is not stable).