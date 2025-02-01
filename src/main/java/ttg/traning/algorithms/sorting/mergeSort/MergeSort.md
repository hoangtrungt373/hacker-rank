# MergeSort
Merge Sort is a divide and conquer algorithm that splits the array into halves, 
sorts each half, and then merges the two sorted halves to produce the final sorted 
array. It is much more efficient than other sorting algorithms like Bubble Sort, 
Selection Sort, and Insertion Sort for large datasets due to its O(n log n) time 
complexity.

#### Algorithm Steps
1. Divide: Split the array into two halves.
2. Conquer: Recursively sort each half.
3. Merge: Combine the two sorted halves into one sorted array.

* The array is recursively split into two halves until each sub-array contains one element (base case).
* The sub-arrays are then merged back together in sorted order.

#### Time Complexity
* Best case (already sorted): 𝑂(𝑛 log n)
* Worst case (reversed list): 𝑂(𝑛 log n)
* Average case: 𝑂(𝑛 log n)

#### Space Complexity
* Space Complexity: O(n) (because it requires additional memory to store temporary arrays during merging).
* Stable sorting algorithm (preserves order of equal elements).

#### UseCase
* Efficient for large datasets (O(n log n) time complexity).
* Stable sorting algorithm (preserves the relative order of equal elements).
* Well-suited for external sorting (when data doesn't fit in memory, such as large files on disk).
* Guaranteed worst-case performance of O(n log n).

❌ Requires additional space (O(n)) for merging, so it might not be suitable for memory-constrained environments.