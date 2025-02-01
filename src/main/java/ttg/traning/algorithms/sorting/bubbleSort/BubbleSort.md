# BubbleSort
Bubble Sort is a simple sorting algorithm that repeatedly steps through 
the list, compares adjacent elements, and swaps them if they are in the 
wrong order. This process is repeated until the list is sorted.

#### Algorithm Steps
1. Start from the first element and compare it with the next one.
2. If the current element is greater than the next one, swap them.
3. Move to the next pair and repeat step 2 for the entire array.
4. After each pass, the largest element "bubbles up" to its correct position.
5. Repeat the process for the remaining elements until the array is sorted.

#### Time Complexity
* Best case (already sorted): 𝑂(𝑛), (if optimized with a swapped flag)
* Worst case (reversed list): 𝑂(𝑛2)
* Average case: 𝑂(𝑛2)

#### UseCase
* Small Data Sets
* Almost Sorted Data (Optimized Bubble Sort)
* When Memory is Limited