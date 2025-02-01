package ttg.traning.algorithms.sorting.heapSort;

/**
 *
 * @author ttg
 */
public class HeapSort {
    // Function to heapify a subtree rooted at index i
    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest); // Recursively heapify the affected subtree
        }
    }

    // Main function to sort an array using heap sort
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i); // Move the root (largest) to end
            heapify(arr, i, 0); // Heapify the reduced heap
        }
    }

    // Helper function to swap two elements
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        heapSort(arr);
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}