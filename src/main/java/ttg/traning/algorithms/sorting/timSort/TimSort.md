# TimSort
TimSort is a hybrid sorting algorithm that combines:

✅ Insertion Sort (good for small datasets)

✅ Merge Sort (good for large datasets)

It is used in Java's Arrays.sort() (for non-primitive arrays) and Python’s sorted() function.

#### Algorithm Steps
1. Divide the array into small chunks (called "runs")
* Typically, size = 32 or 64 (optimal for modern CPUs).
2. Sort each run using Insertion Sort
* Since small chunks are often nearly sorted, Insertion Sort performs well.
3. Merge runs using Merge Sort
* Efficient merging minimizes extra space usage.

#### Time Complexity
* Best case (already sorted): 𝑂(𝑛)
* Worst case (reversed list): 𝑂(𝑛 log n)
* Average case: 𝑂(𝑛 log n)

#### Space Complexity
* Space Complexity: O(n) (due to merging).
* Stable Sort (preserves the relative order of equal elements).

#### UseCase
* Best for real-world applications (used in Java & Python).
* Great for nearly sorted data (O(n) best case).
* Stable sorting (preserves order of equal elements).

❌ Avoid if memory is tight (requires O(n) extra space for merging).
