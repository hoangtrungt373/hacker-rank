# InsertionSort
Insertion Sort is a simple and efficient algorithm that builds the sorted list 
one element at a time by placing each element in its correct position relative 
to the already sorted part.

#### Algorithm Steps
1. Assume the first element is already sorted.
2. Pick the next element and insert it into the correct position in the sorted part.
3. Repeat this process for all elements until the entire array is sorted.

#### Time Complexity
* Best case (already sorted): 𝑂(𝑛)
* Worst case (reversed list): 𝑂(𝑛2)
* Average case: 𝑂(𝑛2)

#### Space Complexity
* Space Complexity: O(1) (In-place sorting)
* Stable sorting algorithm (preserves order of equal elements).

#### UseCase
* Good for small datasets (e.g., fewer than 100 elements).
* Efficient for nearly sorted data (O(n) in best case).
* Stable sorting algorithm (preserves equal elements' order).
* In-place sorting (O(1) extra space).

❌ Slower than MergeSort or QuickSort for large inputs.