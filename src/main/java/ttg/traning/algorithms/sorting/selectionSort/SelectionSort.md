# SelectionSort
Selection Sort is a simple comparison-based sorting algorithm that sorts an 
array by repeatedly finding the minimum element from the unsorted part and 
swapping it with the first element of that part.

#### Algorithm Steps
1. Find the smallest element in the array and swap it with the first element.
2. Find the second smallest element and swap it with the second element.
3. Repeat this process until the entire array is sorted.

#### Time Complexity
* Best case (already sorted): 𝑂(𝑛2)
* Worst case (reversed list): 𝑂(𝑛2)
* Average case: 𝑂(𝑛2)

#### Space Complexity
* Space Complexity: O(1) (In-place sorting, no extra memory needed)
* It makes O(n²) comparisons but only O(n) swaps, which is better than Bubble Sort.

#### UseCase
* Good for small datasets (e.g., fewer than 10 elements).
* Memory-efficient (O(1) space complexity, no extra memory needed).
* Performs fewer swaps than Bubble Sort.
* Works well when writes/swaps are expensive, like in flash memory or EEPROM.

❌ Not stable (does not preserve the relative order of equal elements).