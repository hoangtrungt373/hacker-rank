package ttg.traning.algorithms.sorting.mergeSort;

/**
 *
 * @author ttg
 */
public class MergeSort {
    // Merge function to merge two sub-arrays
    public static void merge(int[] arr, int left, int mid, int right) {
        // Find sizes of two sub-arrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temp arrays
        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr, mid + 1, rightArray, 0, n2);

        // Merge the temp arrays back into the original array
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from leftArray if any
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements from rightArray if any
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Function to implement merge sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2; // Find the middle point

            mergeSort(arr, left, mid); // Sort first half
            mergeSort(arr, mid + 1, right); // Sort second half

            merge(arr, left, mid, right); // Merge both halves
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}