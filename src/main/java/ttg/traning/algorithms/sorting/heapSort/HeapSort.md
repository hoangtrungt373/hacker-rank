# HeapSort
Heap Sort is a comparison-based sorting algorithm that leverages a Binary Heap data structure.
It works by:
1. Building a Max Heap (so the largest element is at the root).
2. Extracting the maximum element (placing it at the end of the array).
3. Heapifying the remaining elements and repeating the process.

#### Algorithm Steps
1. Build a Max Heap from the input array.
2. Swap the root (largest element) with the last element in the heap.
3. Reduce heap size and heapify the root.
4. Repeat until the heap size is 1.

#### Time Complexity
* Best case (already sorted): 𝑂(𝑛 log n)
* Worst case (reversed list): 𝑂(𝑛 log n)
* Average case: 𝑂(𝑛 log n)

#### Space Complexity
* Space Complexity: O(1) (Heap Sort is in-place, meaning no extra memory is used).
* Not Stable (relative order of equal elements may change).

#### UseCase
* Good for large datasets (O(n log n) worst case).
* In-place sorting (O(1) extra memory).
* Does not require additional memory like Merge Sort.

❌ Avoid Heap Sort if:
* You need a stable sort (Heap Sort is not stable).
* You need adaptive sorting (like Insertion Sort, which performs well on nearly sorted arrays).