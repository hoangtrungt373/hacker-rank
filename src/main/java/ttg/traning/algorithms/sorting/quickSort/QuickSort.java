package ttg.traning.algorithms.sorting.quickSort;

/**
 *
 * @author ttg
 */
public class QuickSort {
    // Function to partition the array
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Choosing last element as pivot
        int i = low - 1; // Pointer for smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) { // Swap if current element is smaller than pivot
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high); // Place pivot in the correct position
        return i + 1;
    }

    // Function to perform Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high); // Partition index

            quickSort(arr, low, pi - 1); // Sort left sub-array
            quickSort(arr, pi + 1, high); // Sort right sub-array
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
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}